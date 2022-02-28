package com.ask.log.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 001. Smallest Value of the Rearranged Number
 * 001. Smallest Value of the Rearranged Number
 * You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.
 *
 * Return the rearranged number with minimal value.
 *
 * Note that the sign of the number does not change after rearranging the digits.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 310
 * Output: 103
 * Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310.
 * The arrangement with the smallest value that does not contain any leading zeros is 103.
 * Example 2:
 *
 * Input: num = -7605
 * Output: -7650
 * Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.
 * The arrangement with the smallest value that does not contain any leading zeros is -7650.
 *
 *
 * Constraints:
 *
 * -1015 <= num <= 1015
 */
public class SmallestRearrangeNumber {

    public static void main(String[] args) {
        SmallestRearrangeNumber smallestRearrangeNumber = new SmallestRearrangeNumber();
        int[] input = new int[] {1,0,0};
        System.out.println(Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining("")));
//        System.out.println(smallestRearrangeNumber.smallestNumber(310));
//        System.out.println(smallestRearrangeNumber.smallestNumber(-7605));
//        System.out.println(smallestRearrangeNumber.smallestNumber(95005));
        System.out.println(smallestRearrangeNumber.smallestNumber(321));
    }

    public long smallestNumber(long num) {
        if (num < 10 && num > -9) return num;
        List<Long> holder = new ArrayList<>();
        long temp = Math.abs(num);
        while (temp > 0) {
            holder.add(temp%10);
            temp = temp/10;
        }

        long[] data = holder.stream().sorted().mapToLong(i -> i).toArray();
        if (num < 0) {
            StringBuilder stringBuilder = new StringBuilder("-");
            for (int index = data.length-1; index >=0; index--) {
                stringBuilder.append(data[index]);
            }
            return Long.parseLong(stringBuilder.toString());
        } else {
            StringBuilder builder = new StringBuilder();
            int tempIndex = 0;
            while (data[tempIndex] ==0) {
                tempIndex++;
            }
            builder.append(data[tempIndex]);
            for (int i = 0; i < tempIndex; i++) {
                builder.append(data[i]);
            }
            for (int i = tempIndex+1; i < data.length; i++) {
                builder.append(data[i]);
            }
            return Long.parseLong(builder.toString());
        }
    }
}
