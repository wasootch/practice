package org.example.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

///
/// 49. Group Anagrams
/// Medium
///
/// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
///
/// Example 1:
/// Input: strs = ["eat","tea","tan","ate","nat","bat"]
/// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
/// Explanation:
/// There is no string in strs that can be rearranged to form "bat".
/// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
/// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
///
/// Example 2:
/// Input: strs = [""]
/// Output: [[""]]
///
/// Example 3:
/// Input: strs = ["a"]
/// Output: [["a"]]
///
/// Constraints:
/// 1 <= strs.length <= 104
/// 0 <= strs[i].length <= 100
/// strs[i] consists of lowercase English letters.
///
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
