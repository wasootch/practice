package org.example.strings;

import java.util.HashMap;

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
