package org.example.strings;

///
/// 5. Longest Palindromic Substring
/// Medium
///
/// Given a string s, return the longest palindromic substring in s.
///
/// Example 1:
/// Input: s = "babad"
/// Output: "bab"
/// Explanation: "aba" is also a valid answer.
///
/// Example 2:
/// Input: s = "cbbd"
/// Output: "bb"
///
/// Constraints:
/// 1 <= s.length <= 1000
/// s consist of only digits and English letters.
///
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > longest.length()) {
                longest = s.substring(i - (len - 1) / 2, i + len / 2 + 1);
            }
        }

        return longest;
    }

    int expand(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
