package com.ask.log.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParanthesis {

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("()"));
        System.out.println(validParanthesis.isValid("()]"));
        System.out.println(validParanthesis.isValid("[()]"));
        System.out.println(validParanthesis.isValid("[()]}"));
    }
    public boolean isValid(String s) {
        Map<String, String> lookup = new HashMap<>();
        lookup.put("]", "[");
        lookup.put(")", "(");
        lookup.put("}", "{");
        Stack<String> holder = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            String mapVal = lookup.get(temp);
            if (mapVal != null) {
                 if (holder.isEmpty() || !mapVal.equalsIgnoreCase(holder.pop())) {
                     return false;
                 }
            } else {
                holder.push(temp);
            }


        }
        return holder.isEmpty();
    }
}
