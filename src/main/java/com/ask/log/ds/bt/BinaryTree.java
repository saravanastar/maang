package com.ask.log.ds.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        TreeNode<Integer> parentNode = binaryTree.insert(5, null);
        parentNode = binaryTree.insert(7, parentNode);
        parentNode = binaryTree.insert(8, parentNode);
        parentNode = binaryTree.insert(9, parentNode);
        parentNode = binaryTree.insert(2, parentNode);
        parentNode = binaryTree.insert(3, parentNode);
        parentNode = binaryTree.insert(4, parentNode);
        parentNode = binaryTree.insert(1, parentNode);
        
        binaryTree.bfs(parentNode);
        System.out.println("dfs stars");
        binaryTree.dfs(parentNode);
        System.out.println("inorder starts here");
        binaryTree.inOrderTraversal(parentNode);
        System.out.println("preorder starts here");
        binaryTree.preOrderTraversal(parentNode);
        System.out.println("postorder starts here");
        binaryTree.postOrderTraversal(parentNode);
    }

    private void bfs(final TreeNode<Integer> parentNode) {
        TreeNode<Integer> currentNode = parentNode;
        Queue<TreeNode<Integer>> treeNodes = new LinkedList<>();
        treeNodes.add(currentNode);
        while (!treeNodes.isEmpty()) {
            TreeNode<Integer> treeNode = treeNodes.poll();
            System.out.println(treeNode.getData());
            if (treeNode.getLeft() != null) {
                treeNodes.add(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                treeNodes.add(treeNode.getRight());
            }
        }
    }

    private void dfs(final TreeNode<Integer> parentNode) {
        Stack<TreeNode<Integer>> treeNodes = new Stack<>();
        treeNodes.push(parentNode);
        while (!treeNodes.isEmpty()) {
            TreeNode<Integer> treeNode = treeNodes.pop();
            System.out.println(treeNode.getData());
            if (treeNode.getLeft() != null) {
                treeNodes.add(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                treeNodes.add(treeNode.getRight());
            }
        }
    }

    public TreeNode<Integer> insert(final int val, TreeNode<Integer> parentTreeNode) {
        if (parentTreeNode == null) {
            return new TreeNode<>(val);
        }
        TreeNode<Integer> currentTreeNode = parentTreeNode;

        while (currentTreeNode != null) {
            if (val < currentTreeNode.getData()) {
                if (currentTreeNode.getLeft() == null) {
                    currentTreeNode.setLeft(new TreeNode<>(val));
                    break;
                }
                currentTreeNode = currentTreeNode.getLeft();
            }
            if (val > currentTreeNode.getData()) {
                if (currentTreeNode.getRight() == null) {
                    currentTreeNode.setRight(new TreeNode<>(val));
                    break;
                }
                currentTreeNode = currentTreeNode.getRight();
            }
        }
        return parentTreeNode;
    }

    private void inOrderTraversal(final TreeNode<Integer> treeNode) {
        if (treeNode == null)
            return;
        inOrderTraversal(treeNode.getLeft());
        System.out.println(treeNode.getData());
        inOrderTraversal(treeNode.getRight());
    }

    private void preOrderTraversal(final TreeNode<Integer> treeNode) {
        if (treeNode == null)
            return;
        System.out.println(treeNode.getData());
        preOrderTraversal(treeNode.getLeft());
        preOrderTraversal(treeNode.getRight());
    }

    private void postOrderTraversal(final TreeNode<Integer> treeNode) {
        if (treeNode == null)
            return;

        postOrderTraversal(treeNode.getLeft());
        postOrderTraversal(treeNode.getRight());
        System.out.println(treeNode.getData());
    }
}
