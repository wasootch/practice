package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestRepeatingCharacterReplacementTest {

    private final LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

    @Test
    public void testCharacterReplacement_example1() {
        assertEquals(solution.characterReplacement("ABAB", 2), 4);
    }

    @Test
    public void testCharacterReplacement_example2() {
        assertEquals(solution.characterReplacement("AABABBA", 1), 4);
    }

    @Test
    public void testCharacterReplacement_kZero_longestRun() {
        assertEquals(solution.characterReplacement("AAABBBCCC", 0), 3);
    }

    @Test
    public void testCharacterReplacement_kZero_allSame() {
        assertEquals(solution.characterReplacement("AAAA", 0), 4);
    }

    @Test
    public void testCharacterReplacement_kCoversWholeString() {
        assertEquals(solution.characterReplacement("ABCD", 4), 4);
    }

    @Test
    public void testCharacterReplacement_kExceedsLength() {
        assertEquals(solution.characterReplacement("ABCD", 10), 4);
    }

    @Test
    public void testCharacterReplacement_singleChar() {
        assertEquals(solution.characterReplacement("A", 0), 1);
        assertEquals(solution.characterReplacement("A", 5), 1);
    }

    @Test
    public void testCharacterReplacement_allSameChar() {
        assertEquals(solution.characterReplacement("ZZZZZ", 2), 5);
    }

    @Test
    public void testCharacterReplacement_allDifferent_kOne() {
        assertEquals(solution.characterReplacement("ABCDE", 1), 2);
    }

    @Test
    public void testCharacterReplacement_alternating_kOne() {
        assertEquals(solution.characterReplacement("ABABABABAB", 1), 3);
    }

    @Test
    public void testCharacterReplacement_majorityAtEnd() {
        assertEquals(solution.characterReplacement("ABBBBBB", 1), 7);
    }

    @Test
    public void testCharacterReplacement_majorityAtStart() {
        assertEquals(solution.characterReplacement("AAAAAAB", 1), 7);
    }

    @Test
    public void testCharacterReplacement_twoChars_kOne() {
        assertEquals(solution.characterReplacement("AB", 1), 2);
    }

    @Test
    public void testCharacterReplacement_twoChars_kZero() {
        assertEquals(solution.characterReplacement("AB", 0), 1);
    }

    @Test
    public void testCharacterReplacement_windowShrink() {
        assertEquals(solution.characterReplacement("BAAAB", 2), 5);
    }

    @Test
    public void testCharacterReplacement_lowercase() {
        assertEquals(solution.characterReplacement("aabba", 1), 3);
    }
}
