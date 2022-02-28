package com.ask.log.ds.bt;

import java.util.Stack;

public class TreeOutLine {

    public static void main(String[] args) {
        TreeOutLine treeOutLine = new TreeOutLine();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        treeOutLine.outline(root);
    }
    
    private void outline(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode currentNode = root;

       while (currentNode != null) {
           TreeNode node = currentNode.right;
           if (node != null)
               treeNodes.add(node);
           currentNode = node;
       }
        treeNodes.add(root);
        currentNode = root;
        while (currentNode != null) {
            TreeNode node = currentNode.left;
            if (node != null)
                treeNodes.add(node);
            currentNode = node;
        }
        while (!treeNodes.isEmpty()) {
            System.out.println(treeNodes.pop().val);
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
