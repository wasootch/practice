package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidAnagramTest {

    private final ValidAnagram solution = new ValidAnagram();

    @Test
    public void testIsAnagram_example1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testIsAnagram_example2() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    public void testIsAnagram_identicalStrings() {
        assertTrue(solution.isAnagram("abc", "abc"));
    }

    @Test
    public void testIsAnagram_singleCharMatch() {
        assertTrue(solution.isAnagram("a", "a"));
    }

    @Test
    public void testIsAnagram_singleCharMismatch() {
        assertFalse(solution.isAnagram("a", "b"));
    }

    @Test
    public void testIsAnagram_differentLengths() {
        assertFalse(solution.isAnagram("abc", "ab"));
        assertFalse(solution.isAnagram("ab", "abc"));
    }

    @Test
    public void testIsAnagram_sameLettersWrongCount() {
        assertFalse(solution.isAnagram("aab", "abb"));
    }

    @Test
    public void testIsAnagram_allSameLetterMatch() {
        assertTrue(solution.isAnagram("aaaa", "aaaa"));
    }

    @Test
    public void testIsAnagram_allSameLetterCountMismatch() {
        assertFalse(solution.isAnagram("aaa", "aaaa"));
    }

    @Test
    public void testIsAnagram_reversed() {
        assertTrue(solution.isAnagram("abcde", "edcba"));
    }

    @Test
    public void testIsAnagram_allAlphabetLetters() {
        assertTrue(solution.isAnagram("abcdefghijklmnopqrstuvwxyz",
                "zyxwvutsrqponmlkjihgfedcba"));
    }

    @Test
    public void testIsAnagram_sameLengthDifferentLetters() {
        assertFalse(solution.isAnagram("aaaa", "bbbb"));
    }
}
