package com.ask.log.algo;

import java.util.Arrays;

public class CharSuffixCheck {
    public static void main(String[] args) {
        String charTest = "test1";
        char[] array = new char[10];
        Arrays.fill(array, ' ');
        System.arraycopy(charTest.toCharArray(), 0, array, 0 , Math.min(charTest.length(), array.length));
        System.out.println(String.valueOf(array));
    }
}
