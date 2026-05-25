package org.example.stack;

import java.util.Stack;

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
