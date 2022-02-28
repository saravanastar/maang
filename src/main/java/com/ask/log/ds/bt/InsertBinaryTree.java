package com.ask.log.ds.bt;

public class InsertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return  new TreeNode(val);
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (val <= currentNode.val) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(val);
                    currentNode = null;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(val);
                    currentNode = null;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        
        return root;
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
