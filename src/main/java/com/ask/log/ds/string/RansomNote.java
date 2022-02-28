package com.ask.log.ds.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aba"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            String temp = String.valueOf(ransomNote.charAt(i));
            map.computeIfPresent(temp, (k, v) -> v + 1);
            map.putIfAbsent(temp, 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            String temp = String.valueOf(magazine.charAt(i));
            Integer value = map.get(temp);
            if (value == null) {
                continue;
            }
            if (value - 1 == 0) {
                map.remove(temp);
            } else {
                map.put(temp, value - 1);
            }
        }
        return map.isEmpty();
    }
}
