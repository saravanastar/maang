package com.ask.log.ds.array;

import java.util.Arrays;

/**
 * Array Rotation with different methodology.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int rotateTimes = 24;
        Arrays.stream(times(input, rotateTimes))
                .forEach(System.out::println);
        System.out.println("rotate by each starts");
        Arrays.stream(rotateByEach(input, rotateTimes))
                .forEach(System.out::println);

        System.out.println("rotate sub array starts");
        Arrays.stream(rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, rotateTimes))
                .forEach(System.out::println);
    }

    /**
     * Rotate using the array copy method.
     *
     * @param input int[].
     * @param times number of times rotate
     * @return int[].
     */
    private static int[] times(final int[] input, int times) {
        int modulo = times % input.length;
        int[] result = new int[input.length];
        System.arraycopy(input, modulo, result, 0, (input.length) - modulo);
        System.arraycopy(input, 0, result, (input.length) - modulo, modulo);
        return result;
    }

    /**
     * Rotate number of times straight.
     *
     * @param input int[].
     * @param times int.
     * @return int[].
     */
    private static int[] rotateByEach(final int[] input, int times) {

        if (times > 0) {
            int locator = 0;
            int temp = input[locator];
            while (locator + 1 < input.length) {
                input[locator] = input[locator + 1];
                locator++;
            }
            input[input.length - 1] = temp;
            return rotateByEach(input, times - 1);
        }
        return input;
    }


    private static int[] rotate(final int[] input, int times) {
        int modulo = times % input.length;
        int[] firstHalfReverse = reverse(input, 0, modulo - 1);
        int[] secondHalfReverse = reverse(firstHalfReverse, modulo, input.length - 1);
        return reverse(secondHalfReverse, 0, input.length - 1);
    }

    private static int[] reverse(final int[] input, int start, int end) {
        while (start < end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return input;
    }
}
