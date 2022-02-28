package com.ask.log.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(90>>3);
        System.out.println(90/Math.pow(2, 3));
        System.out.println(2^3);
    }
    public int singleNumber(int[] nums) {
        Set<Integer> holder = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            if (!holder.add(nums[i]))
                holder.remove(nums[i]);
        }
        return holder.stream().findFirst().orElse(0);
    }
}
