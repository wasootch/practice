package org.example.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
