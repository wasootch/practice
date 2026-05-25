package org.example.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String id = getId(str);
            if (!map.containsKey(id)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(id, list);
            } else {
                List<String> l = map.get(id);
                l.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    String getId(String str) {
        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(",");
        }
        return sb.toString();
    }
}
