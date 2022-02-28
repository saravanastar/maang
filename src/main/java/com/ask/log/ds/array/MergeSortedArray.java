package com.ask.log.ds.array;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        Arrays.stream(nums1).forEach(num -> {
            System.out.println(num  + "\t");
        });

         nums1 = new int[]{2,0};
        mergeSortedArray.merge(nums1, 1, new int[]{1}, 1);
        Arrays.stream(nums1).forEach(num -> {
            System.out.println(num  + "\t");
        });
        nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        mergeSortedArray.merge(nums1, 6, new int[]{1,2,2}, 3);
        Arrays.stream(nums1).forEach(num -> {
            System.out.println(num  + "\t");
        });
        nums1 = new int[]{0};
        mergeSortedArray.merge(nums1, 0, new int[]{1}, 1);
        Arrays.stream(nums1).forEach(num -> {
            System.out.println(num  + "\t");
        });

        nums1 = new int[]{4,5,6,0,0,0};
        mergeSortedArray.merge(nums1, 3, new int[]{1,2,3}, 3);
        Arrays.stream(nums1).forEach(num -> {
            System.out.println(num  + "\t");
        });
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m ==0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n ==0) {
            return;
        }
        int mCurrent = m-1;
        int nCurrent = n-1;
        int lastIndex = m-1;
        while(nCurrent >= 0) {
            if (nums1[mCurrent] <= nums2[nCurrent]) {

                move(nums1, mCurrent+1, lastIndex+1);
                nums1[mCurrent+1] = nums2[nCurrent];
                lastIndex++;
                nCurrent--;
            } else if (nums1[mCurrent] > nums2[nCurrent]) {
                if (mCurrent == 0) {
                    move(nums1, 0, lastIndex+1);
                    nums1[mCurrent] = nums2[nCurrent];
                    nCurrent--;
                    lastIndex++;
                } else {
                    mCurrent--;
                }

            }
        }
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int mCurrent = 0;
//        int nCurrent = 0;
//        while (nCurrent < n) {
//            if (nums1[mCurrent] >= nums2[nCurrent]) {
//                move(nums1, mCurrent, nums1.length-1);
//                nums1[mCurrent] = nums2[nCurrent];
//                mCurrent++;
//                nCurrent++;
//            } else  if (nums1[mCurrent] < nums2[nCurrent]) {
//                if (nums1[mCurrent] == 0) {
//                    nums1[mCurrent] = nums2[nCurrent];
//                    nCurrent++;
//                }
//                mCurrent++;
//            }
//
//        }
//
//    }
//
    private void move(final int[] nums1, final int start, int end) {
        if (start < end) {
            nums1[end] = nums1[end - 1];
            end--;
            move(nums1, start, end);
        }

    }
}
