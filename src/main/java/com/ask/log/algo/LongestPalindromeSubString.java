package com.ask.log.algo;

public class LongestPalindromeSubString {
    public static void main(String[] args) {
        LongestPalindromeSubString longestPalindromeSubString = new LongestPalindromeSubString();
        System.out.println(longestPalindromeSubString.longestPalindromeBruteForce("babad"));
        System.out.println(longestPalindromeSubString.longestPalindromeBruteForce("cbbd"));
        System.out.println(longestPalindromeSubString.longestPalindrome("babad"));
        System.out.println(longestPalindromeSubString.longestPalindrome("cbbd"));
        System.out.println(longestPalindromeSubString.longestPalindromeBruteForce("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));

    }

    public String longestPalindrome(String s) {
        int counter = 0;
        String result = "";
        while (counter < s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = counter; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                if (isPalinDrome(stringBuilder)) {
                    if (result.length() < stringBuilder.length()) {
                        result = stringBuilder.toString();
                    }
                }
            }
            counter++;
        }
        return result;
    }

    private int longestPalindromeBruteForce(final String input) {
        int counter = 0;
        int max = 0;
        while (counter < input.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = counter; i < input.length(); i++) {
                stringBuilder.append(input.charAt(i));
                if (isPalinDrome(stringBuilder)) {
                    max = Math.max(max, stringBuilder.length());
                }
            }
            counter++;
        }
        return max;
    }

    private boolean isPalinDrome(StringBuilder input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
