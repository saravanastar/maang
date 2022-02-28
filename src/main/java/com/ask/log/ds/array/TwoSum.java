package com.ask.log.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{-3,4,3,90};
        Arrays.stream(twoSum.twoSum(input, 0)).forEach(num -> {
            System.out.print(num);
            System.out.print("\t");
        });
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> container = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int toLookup = target - temp;
            if (container.containsKey(toLookup)) {
                Integer index = container.get(toLookup);
                return new int[]{index, i};
            } else {
                container.put(temp, i);
            }
        }
        return new int[]{};


    }
}
