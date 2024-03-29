package com.leet.amazon;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Leet: 20. Valid Parentheses (Easy)
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Poem Runtime: 1 ms, faster than 98.83% of Java online submissions for Valid Parentheses.
 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Valid Parentheses
 */
public class EasyValidParentheses {

    public final static void main(String[] args) {

        EasyValidParentheses tester = new EasyValidParentheses();
        // Example 1: Input: "()" Output: true
        System.out.println(tester.isValid("()"));
        // Example 2: Input: "()[]{}"Output: true
        System.out.println(tester.isValid("()[]{}"));
        // Example 3: Input: "(]" Output: false
        System.out.println(tester.isValid("(]"));
        // Example 4: Input: "([)]" Output: false
        System.out.println(tester.isValid("([)]"));
        // Example 5: Input: "{[]}" Output: true
        System.out.println(tester.isValid("{[]}"));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        char[] chars = s.toCharArray();
        for(char c: chars) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;

                char pop = stack.pop();
                if (c == ']' && pop != '[' || c == ')' && pop != '(' || c == '}' && pop != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
