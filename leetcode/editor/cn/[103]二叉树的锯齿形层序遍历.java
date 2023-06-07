//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 775 👎 0


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>res = new ArrayList<>();
        if(root==null)return res;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.addLast(root);
        List<Integer>arr = new ArrayList<>();
        int idx = 0;
        while(!deque1.isEmpty()) {
            TreeNode node = deque1.pollFirst();
            if(node.left != null) deque2.addLast(node.left);
            if(node.right != null) deque2.addLast(node.right);
            arr.add(node.val);
            if(deque1.isEmpty()) {
                deque1 = deque2;
                deque2 = new LinkedList<>();
                if((idx%2) == 0) {
                    res.add(arr);
                } else {
                    Collections.reverse(arr);
                    res.add(arr);
                }
                arr = new ArrayList<>();
                idx++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
