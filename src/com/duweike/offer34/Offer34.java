package com.duweike.offer34;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        findPath(root,target,list,temp);
        return list;

    }

    private static void findPath(TreeNode root, int target, List<List<Integer>> list, List<Integer>temp) {
        if(root==null) return ;
        if(root.left == null && root.right == null) {
            if(target == root.val) {
                List<Integer> t = new ArrayList<>(temp);
                t.add(root.val);
                list.add(t);
            }
            return ;
        } else {
            temp.add(root.val);
           // System.out.println(root.val);
            findPath(root.left, target-root.val,list,temp);
            findPath(root.right, target-root.val,list,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {


        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        TreeNode node3 = new TreeNode(11,node4,node5);
        TreeNode node2 = new TreeNode(4,node3,null);

        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(4,node6, node7);

        TreeNode node9 = new TreeNode(13);
        TreeNode node10 = new TreeNode(8,node9,node8);

        TreeNode node1 = new TreeNode(5,node2,node10);


        List<List<Integer>> list = pathSum(node1,22);
        for(int i=0;i<list.size();i++) {
            for(int j = 0;j<list.get(i).size();j++) {
                System.out.printf("%d ",list.get(i).get(j));
            }
            System.out.println();
        }

    }
}
