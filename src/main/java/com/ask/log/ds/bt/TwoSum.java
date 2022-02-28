package com.ask.log.ds.bt;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(twoSum.findTarget(root, 28));
    }

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> dfs = new LinkedList<>();
        dfs.add(root);
        Set<Integer> holder = new HashSet<>();
        while(!dfs.isEmpty()) {
            TreeNode temp = dfs.poll();
            int required = k - temp.val;
            if (!holder.isEmpty() && holder.contains(required)) {
                return true;
            }
            holder.add(temp.val);
            if (temp.left != null)
                dfs.add(temp.left);
            if(temp.right != null)
                dfs.add(temp.right);
        }
        return false;
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
