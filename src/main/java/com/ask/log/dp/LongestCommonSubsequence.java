package com.ask.log.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    // "abcde" , "ace"

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lookup = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < lookup.length; i++) {
            for (int j = 1; j < lookup[0].length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    lookup[i][j] = 1 + lookup[i-1][j-1];
                } else {
                    lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
                }
            }
        }
        return lookup[text1.length()][text2.length()];
    }
}
