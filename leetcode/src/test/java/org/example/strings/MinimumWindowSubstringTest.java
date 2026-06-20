package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinimumWindowSubstringTest {

    private final MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    public void testMinWindow_example1() {
        // "BANC" is the shortest window containing A, B, C
        assertEquals(solution.minWindow("ADOBECODEBANC", "ABC"), "BANC");
    }

    @Test
    public void testMinWindow_example2() {
        // entire string is the only window
        assertEquals(solution.minWindow("a", "a"), "a");
    }

    @Test
    public void testMinWindow_example3() {
        // t requires two 'a's but s only has one
        assertEquals(solution.minWindow("a", "aa"), "");
    }

    @Test
    public void testMinWindow_noValidWindow() {
        // t contains a character not present in s at all
        assertEquals(solution.minWindow("abc", "d"), "");
    }

    @Test
    public void testMinWindow_tLongerThanS() {
        // t is longer than s so no window is possible
        assertEquals(solution.minWindow("ab", "abc"), "");
    }

    @Test
    public void testMinWindow_exactMatch() {
        // s and t are identical
        assertEquals(solution.minWindow("abc", "abc"), "abc");
    }

    @Test
    public void testMinWindow_duplicatesInT() {
        // t has two B's; window must contain at least two B's
        assertEquals(solution.minWindow("ADOBECODEBANC", "BBC"), "BECODEB");
    }

    @Test
    public void testMinWindow_singleCharTNotInS() {
        assertEquals(solution.minWindow("xyz", "a"), "");
    }

    @Test
    public void testMinWindow_windowAtStart() {
        // valid window starts at the beginning
        assertEquals(solution.minWindow("ABCDEF", "AB"), "AB");
    }

    @Test
    public void testMinWindow_windowAtEnd() {
        // valid window is at the end of s
        assertEquals(solution.minWindow("DEFABC", "ABC"), "ABC");
    }

    @Test
    public void testMinWindow_windowInMiddle() {
        // minimum window is buried in the middle
        assertEquals(solution.minWindow("XYZABCPQR", "ABC"), "ABC");
    }

    @Test
    public void testMinWindow_caseSensitive() {
        // uppercase and lowercase are distinct
        assertEquals(solution.minWindow("aAbB", "AB"), "AbB");
    }

    @Test
    public void testMinWindow_caseSensitiveMixedT() {
        // lowercase a and uppercase A are different characters
        assertEquals(solution.minWindow("aAbB", "aB"), "aAbB");
    }

    @Test
    public void testMinWindow_allSameCharInS() {
        // s is all 'a', t needs one 'a' — window should shrink to single char
        assertEquals(solution.minWindow("aaaa", "a"), "a");
    }

    @Test
    public void testMinWindow_allSameCharInSAndT() {
        // s = "aaaa", t = "aa" — smallest window with two a's
        assertEquals(solution.minWindow("aaaa", "aa"), "aa");
    }

    @Test
    public void testMinWindow_tRequiresMoreDuplicatesThanS() {
        // s has two a's but t needs three
        assertEquals(solution.minWindow("aab", "aaa"), "");
    }

    @Test
    public void testMinWindow_multipleValidWindowsReturnsMinimum() {
        // both "BA" and "AB" are length-2 windows; minimum is 2
        assertEquals(solution.minWindow("BAAB", "AB").length(), 2);
    }

    @Test
    public void testMinWindow_tHasOneChar() {
        // t is a single character that appears multiple times in s
        assertEquals(solution.minWindow("abcabc", "b"), "b");
    }

    @Test
    public void testMinWindow_largeWindowShrinks() {
        // window must cover all of t, then shrink as left pointer advances
        assertEquals(solution.minWindow("AAABBBCCC", "ABC"), "ABBBC");
    }

    @Test
    public void testMinWindow_tWithDuplicatesScatteredInS() {
        // two 'a's needed; they are far apart but a closer pair exists
        assertEquals(solution.minWindow("acbbaca", "aba"), "baca");
    }

    @Test
    public void testMinWindow_sEqualToT() {
        // s and t are the same single-character string
        assertEquals(solution.minWindow("z", "z"), "z");
    }

    @Test
    public void testMinWindow_noOverlapBetweenSAndT() {
        // no character in t exists in s
        assertEquals(solution.minWindow("aabbcc", "xyz"), "");
    }

    @Test
    public void testMinWindow_repeatedCharNeededExactAmount() {
        // t = "aab", s has exactly two a's and one b in a tight window
        assertEquals(solution.minWindow("aab", "aab"), "aab");
    }
}
