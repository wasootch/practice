package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RansomNoteTest {

    private final RansomNote solution = new RansomNote();

    @Test
    public void testCanConstruct_example1() {
        assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    public void testCanConstruct_example2() {
        assertFalse(solution.canConstruct("aa", "ab"));
    }

    @Test
    public void testCanConstruct_example3() {
        assertTrue(solution.canConstruct("aa", "aab"));
    }

    @Test
    public void testCanConstruct_emptyRansomNote() {
        // empty note can always be constructed
        assertTrue(solution.canConstruct("", "abc"));
    }

    @Test
    public void testCanConstruct_emptyRansomNoteEmptyMagazine() {
        assertTrue(solution.canConstruct("", ""));
    }

    @Test
    public void testCanConstruct_exactMatch() {
        // magazine has exactly the letters needed, nothing more
        assertTrue(solution.canConstruct("abc", "abc"));
    }

    @Test
    public void testCanConstruct_magazineIsSuperset() {
        assertTrue(solution.canConstruct("abc", "aabbcc"));
    }

    @Test
    public void testCanConstruct_notEnoughOfOneLetter() {
        // needs two 'a's, magazine only has one
        assertFalse(solution.canConstruct("aa", "a"));
    }

    @Test
    public void testCanConstruct_letterMissingFromMagazine() {
        assertFalse(solution.canConstruct("az", "abcdefghijklmnopqrstuvwxy"));
    }

    @Test
    public void testCanConstruct_magazineLongerButMissingChar() {
        // magazine is much larger but still missing 'z'
        assertFalse(solution.canConstruct("z", "aabbccddeeff"));
    }

    @Test
    public void testCanConstruct_repeatedLettersExactCount() {
        assertTrue(solution.canConstruct("aabbcc", "abcabc"));
    }

    @Test
    public void testCanConstruct_repeatedLettersOneShort() {
        assertFalse(solution.canConstruct("aabbcc", "ababc"));
    }

    @Test
    public void testCanConstruct_singleCharMatch() {
        assertTrue(solution.canConstruct("a", "a"));
    }

    @Test
    public void testCanConstruct_singleCharNoMatch() {
        assertFalse(solution.canConstruct("b", "a"));
    }
}
