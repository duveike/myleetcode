//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 1168 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val==key) {
            if(root.right==null) {
                return root.left;
            } else {
                findMin(root.right).left = root.left;
                return root.right;
            }
        }
        TreeNode ans = root;
        TreeNode node = find(root, key);
        delete(node, key);
        return ans;

    }

    private TreeNode find(TreeNode root, int key) {
        if(root == null || root.val==key) {
            return root;
        }
        while(root!=null && root.val!=key) {
            if(root.val<key) {
                if(root.right!=null && root.right.val==key) return root;
                root = root.right;
            } else {
                if(root.left!=null && root.left.val == key) return root;
                root = root.left;
            }
        }
        return root;
    }

    private void delete(TreeNode root, int  key) {
        if(root==null) return;
        if(root.left!=null && root.left.val==key) {
            if(root.left.right==null) {
                root.left = root.left.left;
            } else {
                findMin(root.left.right).left = root.left.left;
                root.left = root.left.right;
            }
            return ;
        }

        if(root.right!=null && root.right.val==key) {
            if(root.right.right==null) {
                root.right = root.right.left;
            } else {
                findMin(root.right.right).left = root.right.left;
            }
        }
    }

    private TreeNode findMin(TreeNode root) {
        if(root==null) return null;
        if(root.left==null) return root;
        return findMin(root.left);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
