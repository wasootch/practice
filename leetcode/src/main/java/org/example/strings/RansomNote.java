package org.example.strings;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : magazine.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c) - 1;
            map.merge(c, -1, Integer::sum);
            if (count == 0) {
                map.remove(c);
            }
        }

        return true;
    }
}
