package org.example.strings;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;

        int[] sc = new int[26];
        for (char c : s.toCharArray()) {
            sc[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            sc[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (sc[i] != 0) return false;
        }
        return true;
    }
}
