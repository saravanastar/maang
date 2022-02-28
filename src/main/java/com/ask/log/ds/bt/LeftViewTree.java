package com.ask.log.ds.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
    public static void main(String[] args) {
        LeftViewTree leftViewTree = new LeftViewTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        leftViewTree.leftViewTree(root);
    }

    private void leftViewTree(TreeNode root){
        Queue<TreeNode> holder =  new LinkedList<>();
        holder.add(root);
        while (!holder.isEmpty()) {
            int size = holder.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = holder.poll();
                if (i==0) {
                    System.out.println(node.val);
                }
                if (node.left != null)
                    holder.add(node.left);
                if (node.right != null)
                    holder.add(node.right);
            }
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
