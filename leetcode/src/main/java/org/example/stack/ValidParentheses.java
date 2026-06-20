package org.example.stack;

import java.util.Stack;

///
/// 20. Valid Parentheses
/// Easy
///
/// Given a string s containing just the characters '(', ')', '{', '}', '['and']', determine if the input string is valid.
///
/// An input string is valid if:
/// Open brackets must be closed by the same type of brackets.
/// Open brackets must be closed in the correct order.
/// Every close bracket has a corresponding open bracket of the same type.
///
/// Example 1:
/// Input: s = "()"
/// Output: true
///
/// Example 2:
/// Input: s = "()[]{}"
/// Output: true
///
/// Example 3:
/// Input: s = "(]"
/// Output: false
///
/// Example 4:
/// Input: s = "([])"
/// Output: true
///
/// Example 5:
/// Input: s = "([)]"
/// Output: false
///
/// Constraints:
/// 1 <= s.length <= 104
/// s consists of parentheses only '()[]{}'.
///
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();

                if ((c == ')' && p != '(') || (c == ']' && p != '[') || (c == '}' && p != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
