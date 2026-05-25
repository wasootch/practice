package org.example.strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!isAlphaNumeric(s.charAt(i)) && i < j) {
                i++;
            }
            while (!isAlphaNumeric(s.charAt(j)) && j > i) {
                j--;
            }

            char left = s.charAt(i);
            char right = s.charAt(j);
            if ((int) left >= 96) {
                left = (char) ((int) left - 32);
            }
            if ((int) right >= 96) {
                right = (char) ((int) right - 32);
            }

            if (left == right) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;
    }

    boolean isAlphaNumeric(char c) {
        return ((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z') || (c >= '0') && (c <= '9'));
    }
}
