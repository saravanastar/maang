package com.ask.log.ds.bt;

/**
 * 226. Invert Binary Tree
 * Easy
 *
 * 7226
 *
 * 99
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode result = invertBinaryTree.invertTree(root);

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        result = invertBinaryTree.invertTree(root);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        result = invertBinaryTree.invertTree(root);

    }
    public TreeNode invertTree(TreeNode root) {
         invert(root);
         return root;
    }

    private void invert(TreeNode root) {
      if (root == null)
          return;
      TreeNode tempNode = root.left;
      root.left = root.right;
      root.right = tempNode;
      invert(root.left);
      invert(root.right);
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
