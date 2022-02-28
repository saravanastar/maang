package com.ask.log.ds.array;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionTwoArrays {
    public static void main(String[] args) {
        IntersectionTwoArrays intersectionTwoArrays = new IntersectionTwoArrays();
        Arrays.stream(intersectionTwoArrays.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
                .forEach(System.out::println);

        Arrays.stream(intersectionTwoArrays.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))
                .forEach(System.out::println);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            lookup.computeIfPresent(nums1[i], (k, value) -> 1 + value);
            lookup.computeIfAbsent(nums1[i], k -> 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (lookup.containsKey(nums2[i])) {
                result.add(nums2[i]);
                Integer count = lookup.get(nums2[i]);
                if (count - 1 <= 0) {
                    lookup.remove(nums2[i]);
                } else {
                    lookup.computeIfPresent(nums2[i], (k, value) -> value - 1);
                }
            }
        }


        return result.stream().mapToInt(i -> i).toArray();
    }
}
