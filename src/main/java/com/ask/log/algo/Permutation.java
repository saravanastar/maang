package com.ask.log.algo;


public class Permutation {
    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        permutation.permuteNumber(new int[]{1,2,3}, 0, 2);

    }

    private void permuteNumber(int[] input, int left, int right) {
        if (left == right) {
            print(input);
        } else {
            for (int i = left; i <= right; i++) {
                swap(input, i, left);
                permuteNumber(input, left+1, right);
                swap(input, i, left);

            }
        }
    }

    private void swap(final int[] input, final int i, final int left) {
        int temp = input[i];
        input[i] = input[left];
        input[left] = temp;
    }

    private void print(final int[] input) {
        for (int number:input
             ) {
            System.out.println(number + " ");
        }
        System.out.println();
    }
}
