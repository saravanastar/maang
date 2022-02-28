package com.ask.log.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 5984. Minimum Sum of Four Digit Number After Splitting Digits
 * You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2 by using the digits found in num. Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
 *
 * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
 * Return the minimum possible sum of new1 and new2.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2932
 * Output: 52
 * Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
 * The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
 * Example 2:
 *
 * Input: num = 4009
 * Output: 13
 * Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc.
 * The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.
 */
public class MinimumSumOfDigit {

    public static void main(String[] args) {
        MinimumSumOfDigit minimumSumOfDigit = new MinimumSumOfDigit();
        System.out.println(minimumSumOfDigit.minimumSum(2932));
    }

    public int minimumSum(int num) {
        if (num > 9999) return -1;
        int temp = num;
        List<Integer> data = new ArrayList<>();
        while (temp > 0) {

            int last  = temp%10;
            data.add(last);
            temp = temp/10;
        }
        return -1;
    }
    private List<List<Integer>> permute(int rotate, String input) {
        List<List<Integer>> permute = new ArrayList<>();
        for(int i=  rotate+1; i< input.length();i++) {
            if (i == rotate) {
                int num = input.charAt(i);
                List<Integer> subset = new ArrayList<>();
                final String substring = input.substring(i + 1, input.length());
                if (substring.trim().length() > 0)
                    subset.add(Integer.parseInt(substring));
                subset.add(num);
                permute.add(subset);
            } else {
                List<Integer> subset = new ArrayList<>();
                subset.add(Integer.parseInt(input.substring(0, i)));
                subset.add(Integer.parseInt(input.substring(i, input.length())));
                permute.add(subset);
            }
        }
        return permute;
    }
}
