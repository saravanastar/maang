package com.ask.log.ds.string;

import java.util.*;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(firstUniqueCharacter.firstUniqChar("loveleetcode"));
        System.out.println(firstUniqueCharacter.firstUniqChar("aabb"));
        System.out.println(firstUniqueCharacter.firstUniqChar("aadadaad"));

    }

    public int firstUniqChar(String s) {
        char[] input = s.toCharArray();
        Map<String, List<Integer>> container = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String temp = String.valueOf(input[i]);
            final int finalI = i;
            container.computeIfPresent(temp, (k, v) -> {
                v.add(finalI);
                return v;
            });
            container.computeIfAbsent(temp, k -> {
                List<Integer> integers = new ArrayList<>();
                integers.add(finalI);
                return integers;
            });
        }
        if (container.isEmpty()) {
            return -1;
        }
        return container.entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .findFirst().map(entry -> entry.getValue().stream().findFirst().orElse(-1)).orElse(-1);

    }
}
