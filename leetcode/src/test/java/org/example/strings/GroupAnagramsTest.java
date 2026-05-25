package org.example.strings;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class GroupAnagramsTest {

    private final GroupAnagrams solution = new GroupAnagrams();

    private List<List<String>> normalize(List<List<String>> result) {
        for (List<String> group : result) Collections.sort(group);
        result.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });
        return result;
    }

    private List<List<String>> expected(String[]... groups) {
        List<List<String>> result = new java.util.ArrayList<>();
        for (String[] g : groups) {
            List<String> group = new java.util.ArrayList<>(Arrays.asList(g));
            result.add(group);
        }
        return normalize(result);
    }

    @Test
    public void testGroupAnagrams_example1() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> exp = expected(new String[]{"bat"}, new String[]{"nat", "tan"}, new String[]{"ate", "eat", "tea"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_example2() {
        List<List<String>> result = solution.groupAnagrams(new String[]{""});
        List<List<String>> exp = expected(new String[]{""});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_example3() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"a"});
        List<List<String>> exp = expected(new String[]{"a"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_allSameAnagram() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"abc", "bca", "cab"});
        List<List<String>> exp = expected(new String[]{"abc", "bca", "cab"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_noAnagrams() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"abc", "def", "ghi"});
        List<List<String>> exp = expected(new String[]{"abc"}, new String[]{"def"}, new String[]{"ghi"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_multipleEmptyStrings() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"", "", ""});
        List<List<String>> exp = expected(new String[]{"", "", ""});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_differentLengthsNeverGrouped() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"a", "ab", "abc"});
        List<List<String>> exp = expected(new String[]{"a"}, new String[]{"ab"}, new String[]{"abc"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_singleString() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"hello"});
        List<List<String>> exp = expected(new String[]{"hello"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_twoAnagrams() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"ab", "ba"});
        List<List<String>> exp = expected(new String[]{"ab", "ba"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_twoNonAnagrams() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"ab", "cd"});
        List<List<String>> exp = expected(new String[]{"ab"}, new String[]{"cd"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_sameLettersDifferentCounts() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"aab", "abb"});
        List<List<String>> exp = expected(new String[]{"aab"}, new String[]{"abb"});
        List<List<String>> act = normalize(result);
        assertEquals(act, exp, "expected: " + exp + "\nactual: " + act);
    }

    @Test
    public void testGroupAnagrams_noStringsLost() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(input);
        int total = result.stream().mapToInt(List::size).sum();
        assertEquals(total, input.length);
    }
}
