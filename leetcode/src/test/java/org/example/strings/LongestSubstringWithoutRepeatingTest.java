package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestSubstringWithoutRepeatingTest {

    private final LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

    @Test
    public void testLengthOfLongestSubstring_example1() {
        // "abc" is the longest window
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
    }

    @Test
    public void testLengthOfLongestSubstring_example2() {
        // only window of size 1 (all same char)
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
    }

    @Test
    public void testLengthOfLongestSubstring_example3() {
        // "wke" or "pwe" — length 3
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
    }

    @Test
    public void testLengthOfLongestSubstring_emptyString() {
        assertEquals(solution.lengthOfLongestSubstring(""), 0);
    }

    @Test
    public void testLengthOfLongestSubstring_singleChar() {
        assertEquals(solution.lengthOfLongestSubstring("z"), 1);
    }

    @Test
    public void testLengthOfLongestSubstring_allUnique() {
        // entire string has no repeats
        assertEquals(solution.lengthOfLongestSubstring("abcdef"), 6);
    }

    @Test
    public void testLengthOfLongestSubstring_repeatAtEnd() {
        // "abcd" is the longest, then 'a' repeats
        assertEquals(solution.lengthOfLongestSubstring("abcda"), 4);
    }

    @Test
    public void testLengthOfLongestSubstring_repeatAtStart() {
        // "bcde" is the longest
        assertEquals(solution.lengthOfLongestSubstring("aabcde"), 5);
    }

    @Test
    public void testLengthOfLongestSubstring_longestWindowInMiddle() {
        // "abcde" is the unique window in the middle
        assertEquals(solution.lengthOfLongestSubstring("aabcdea"), 5);
    }

    @Test
    public void testLengthOfLongestSubstring_twoCharsAlternating() {
        // sliding window never exceeds 2: "ab", "ba", "ab"...
        assertEquals(solution.lengthOfLongestSubstring("ababab"), 2);
    }

    @Test
    public void testLengthOfLongestSubstring_withSpacesAndSymbols() {
        // spaces and symbols are valid characters
        assertEquals(solution.lengthOfLongestSubstring("a b!c"), 5);
    }

    @Test
    public void testLengthOfLongestSubstring_duplicateResetsThenGrows() {
        // window resets after 'a' repeats, then "bcd" follows
        assertEquals(solution.lengthOfLongestSubstring("aabcd"), 4);
    }
}
