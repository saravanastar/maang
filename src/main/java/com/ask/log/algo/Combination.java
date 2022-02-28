package com.ask.log.algo;

import java.util.Arrays;

public class Combination {

    public static void main(String[] args) {
        Combination combination = new Combination();
//        combination.stringCombination("abcd".toCharArray(), 0, "");
        char[] data = new char[2];
        combination.stringRCombination("abcde".toCharArray(), 0,data, 0);
    }

    public void stringCombination(char[] input, int index, String data) {

            for (int i = index; i < input.length; i++) {
                stringCombination(input, i + 1, data + input[i]);
                System.out.println(data + input[i]);
            }

    }

    public void stringRCombination(char[] input, int index, char[] data, int r) {
        if (r == 2) {
            System.out.println(String.valueOf(data));
            return;
        }
        for (int i = index; i < input.length; i++) {
            stringRCombination(input, i+1, data, r);
            data[r] = input[i];
            stringRCombination(input, i+1, data, r+1);
        }

    }
}
