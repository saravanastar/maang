package com.ask.log.ds.bt;

import java.util.Stack;

public class InorderSuccessor {
    Stack<TreeNode> treeNodes = new Stack<>();
    Integer prev = null;

    public static void main(String[] args) {
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        System.out.println(inorderSuccessor.inOrderSuccessor(root, 8).val);
        System.out.println(inorderSuccessor.inOrderSuccessor(root, 10).val);
        System.out.println(inorderSuccessor.inOrderSuccessor(root, 14).val);
    }

    private TreeNode inOrderSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode left = inOrderSuccessor(root.left, key);
        if (left != null) {
            return left;
        }
        if (prev != null && prev == key) {
            return root;
        }
        prev = root.val;
//        if (!treeNodes.isEmpty() && treeNodes.pop().val == key) {
//            return root;
//        }
//        treeNodes.push(root);

        return inOrderSuccessor(root.right, key);
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
