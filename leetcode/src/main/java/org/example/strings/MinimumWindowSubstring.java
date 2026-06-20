package org.example.strings;

import java.util.HashMap;
import java.util.Map;

///
/// 76. Minimum Window Substring
/// Hard
///
/// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
/// The testcases will be generated such that the answer is unique.
///
/// Example 1:
/// Input: s = "ADOBECODEBANC", t = "ABC"
/// Output: "BANC"
/// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
///
/// Example 2:
/// Input: s = "a", t = "a"
/// Output: "a"
/// Explanation: The entire string s is the minimum window.
///
/// Example 3:
/// Input: s = "a", t = "aa"
/// Output: ""
/// Explanation: Both 'a's from t must be included in the window.
/// Since the largest window of s only has one 'a', return empty string.
///
/// Constraints:
/// m == s.length
/// n == t.length
/// 1 <= m, n <= 105
/// s and t consist of uppercase and lowercase English letters.
///
/// Follow up: Could you find an algorithm that runs in O(m + n) time?
///
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int remainingTargetChars = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    remainingTargetChars--;
                }
                map.put(c, map.get(c) - 1);
            }

            if (remainingTargetChars == 0) {
                while (true) {
                    char startChar = s.charAt(start);
                    if (map.containsKey(startChar) && map.get(startChar) == 0) {
                        break;
                    }
                    if (map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1);
                    }
                    start++;
                }

                if (end - start < minWindow[1] - minWindow[0]) {
                    minWindow[0] = start;
                    minWindow[1] = end;
                }

                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                remainingTargetChars++;
                start++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}
