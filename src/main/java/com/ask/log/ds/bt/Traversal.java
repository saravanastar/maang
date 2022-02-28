package com.ask.log.ds.bt;

import java.util.*;

/**
 * InOrder - left, root, right
 * PreOrder - root, left, right
 * PostOrder - left, right , root
 */
public class Traversal {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<>(2));
        root.getRight().setLeft(new TreeNode<>(3));
//        List<Integer> list = traversal.preorderTraversal(root);
        List<Integer> list = traversal.inorderTraversal(root);
        list.forEach(System.out::println);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode currentNode = treeNodes.pop();
            result.add((Integer) currentNode.getData());
            if (currentNode.getRight() != null)
                treeNodes.add(currentNode.getRight());
            if (currentNode.getLeft() != null)
                treeNodes.add(currentNode.getLeft());

        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
       if (root == null) {
           return new ArrayList<>();
       }
       List<Integer> left = inorderTraversal(root.getLeft());
       left.add((Integer) root.getData());
       List<Integer> right = inorderTraversal(root.getRight());
       left.addAll(right);
       return left;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = postorderTraversal(root.getLeft());
        List<Integer> right = postorderTraversal(root.getRight());
        left.addAll(right);
        left.add((Integer) root.getData());
        return left;
    }
}
