package com.ask.log.ds.string;

import java.util.HashMap;
import java.util.Map;

/**
 *Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 */
public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
        System.out.println(anagram.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            map.computeIfPresent(temp, (k, v) -> v + 1);
            map.putIfAbsent(temp, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            String temp = String.valueOf(t.charAt(i));
            Integer value = map.get(temp);
            if (value == null) {
                map.putIfAbsent(temp, 1);
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
