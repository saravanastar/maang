package com.ask.log.ds.bt;

public class ValidateBST {
    Integer topRootVal = null;
    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        TreeNode root = new TreeNode(5);
        root.left = new ValidateBST.TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(validateBST.isValidBST(root));

         root = new TreeNode(32);
        root.left = new TreeNode(26);
        root.right = new TreeNode(47);
        root.left.left = new TreeNode(19);
        root.left.left.right = new TreeNode(27);
        root.right.right = new TreeNode(56);
        System.out.println(validateBST.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        int rootVal = root.val;

        if (root.val < min || root.val > max)
            return false;

        return isValid(root.left, min, root.val) && isValid(root.right, rootVal, max);
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
