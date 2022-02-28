package com.ask.log.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ArrayDuplicateElement {
    public static void main(String[] args) {
        ArrayDuplicateElement arrayDuplicateElement = new ArrayDuplicateElement();
        System.out.println(arrayDuplicateElement.containsDuplicate(new int[] {1,2,3,4}));
        System.out.println(arrayDuplicateElement.containsDuplicate(new int[] {1,2,3,4,1}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (final int num : nums) {
            if (!container.add(num)) {
                return true;
            }
        }
        return false;
    }
}
