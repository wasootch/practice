package org.example.strings;

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
