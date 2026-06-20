package org.example.strings;

import java.util.HashMap;

///
/// 424. Longest Repeating Character Replacement
/// Medium
///
/// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
/// Return the length of the longest substring containing the same letter you can get after performing the above operations.
///
/// Example 1:
/// Input: s = "ABAB", k = 2
/// Output: 4
/// Explanation: Replace the two 'A's with two 'B's or vice versa.
///
/// Example 2:
/// Input: s = "AABABBA", k = 1
/// Output: 4
/// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
/// The substring "BBBB" has the longest repeating letters, which is 4.
/// There may exists other ways to achieve this answer too.
///
/// Constraints:
/// 1 <= s.length <= 105
/// s consists of only uppercase English letters.
/// 0 <= k <= s.length
///
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i = 0;
        int max = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));

            while ((j - i + 1) - max > k) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
