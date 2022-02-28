package com.ask.log.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Arrays.stream(quickSort.sort(new int[]{6,5,4,3,2,2,1})).forEach(System.out::println);
        Arrays.stream(quickSort.sort(new int[]{-22,-11,-1,233,2,2,1,0})).forEach(System.out::println);
    }

    public int[] sort(int[] input) {
        int low = 0;
        int high = input.length-1;

        quick(input, low, high);
        return input;
    }

    private void quick(final int[] input, final int low, final int high) {
        if (low < high) {
            int partition = partition(input, low, high);
            swap(input, partition, high);
            quick(input, low, partition-1);
            quick(input, partition+1, high);
        }
    }

    private int partition(int[] input, int left, int right) {
        int pivot = input[right];
        right-=1;
        while (left <= right) {
            if (input[left] > pivot && input[right] < pivot) {
                swap(input, left, right);
            }
            if (input[left] < pivot) {
                left++;
            }
            if (input[right] >= pivot) {
                right--;
            }
        }
        return left;
    }

    private void swap(final int[] input, final int left, final int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

}
