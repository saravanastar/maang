package com.ask.log.ds.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maximumSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = max;
        for (int i = 1; i < nums.length; i++) {
            int temp = max + nums[i];
            if ( temp < nums[i]) {
                max = nums[i];
            } else {
                max = temp;
            }
            result = Math.max(result, max);

        }
        return result;

    }
}
