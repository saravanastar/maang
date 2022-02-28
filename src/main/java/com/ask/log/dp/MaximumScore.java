package com.ask.log.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 *
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 *
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 * Example 2:
 *
 * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * Output: 102
 * Explanation: An optimal solution is as follows:
 * - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
 * - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
 * - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
 * - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
 * - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
 * The total score is 50 + 15 - 9 + 4 + 42 = 102.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 103
 * m <= n <= 105
 * -1000 <= nums[i], multipliers[i] <= 1000
 */
public class MaximumScore {
    int[] nums, multipliers;
    Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        MaximumScore maximumScore = new MaximumScore();
        System.out.println(maximumScore.maximumScore(new int[]{1,2,3}, new int[]{3,2,1}));
        System.out.println(maximumScore.maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
    }



    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        return max(0, nums.length-1, 0, multipliers.length-1);
    }

    /**
     left, right
     left, left
     right,left
     right, right

     **/

    private int max(int leftNum, int rightNum, int leftMultiplier, int rightMultiplier) {
        if (leftNum >= nums.length || leftMultiplier >= multipliers.length || leftNum > rightNum || leftMultiplier > rightMultiplier) return 0;
        if (rightNum == leftNum && leftMultiplier == rightMultiplier) {
            return nums[leftNum] * multipliers[leftMultiplier];
        }
        String key = getKey(leftNum, rightNum, leftMultiplier, rightMultiplier);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int leftVal  = Math.max(nums[leftNum] * multipliers[leftMultiplier] +
                max(leftNum+1, rightNum, leftMultiplier+1, rightMultiplier),
                nums[leftNum] * multipliers[rightMultiplier] +
                        max(leftNum+1, rightNum, leftMultiplier, rightMultiplier-1));

        int rightVal  = Math.max(nums[rightNum] * multipliers[leftMultiplier] +
                        max(leftNum, rightNum-1, leftMultiplier+1, rightMultiplier),
                nums[rightNum] * multipliers[rightMultiplier] +
                        max(leftNum, rightNum-1, leftMultiplier, rightMultiplier-1));

        int result =  Math.max(leftVal, rightVal);
        memo.put(key, result);
        return result;

    }

    private String getKey(final int leftNum, final int rightNum, final int leftMultiplier, final int rightMultiplier) {
        return leftNum + "," + rightNum + "," + leftMultiplier + "," + rightMultiplier;
    }
}
