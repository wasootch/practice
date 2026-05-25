package org.example.strings;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += palindromes(s, i, i);
            count += palindromes(s, i, i + 1);
        }

        return count;
    }

    int palindromes(String s, int left, int right) {
        boolean isOdd = left == right;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int count;
        if (isOdd) {
            count = Math.round((float) (right - left) / 2);
        } else {
            count = Math.round((float) (right - left - 1) / 2);
        }
        return count;
    }
}
