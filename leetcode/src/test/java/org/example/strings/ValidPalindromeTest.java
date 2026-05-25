package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidPalindromeTest {

    private final ValidPalindrome solution = new ValidPalindrome();

    @Test
    public void testIsPalindrome_example1() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testIsPalindrome_example2() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    public void testIsPalindrome_onlySpaces() {
        assertTrue(solution.isPalindrome(" "));
    }

    @Test
    public void testIsPalindrome_singleLetter() {
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    public void testIsPalindrome_singleNonAlphanumeric() {
        assertTrue(solution.isPalindrome("!"));
    }

    @Test
    public void testIsPalindrome_simpleLowercase() {
        assertTrue(solution.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome_simpleNonPalindrome() {
        assertFalse(solution.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindrome_mixedCaseNoPunctuation() {
        assertTrue(solution.isPalindrome("RaceCar"));
    }

    @Test
    public void testIsPalindrome_numericPalindrome() {
        assertTrue(solution.isPalindrome("12321"));
    }

    @Test
    public void testIsPalindrome_numericNonPalindrome() {
        assertFalse(solution.isPalindrome("12345"));
    }

    @Test
    public void testIsPalindrome_alphanumericPalindrome() {
        assertTrue(solution.isPalindrome("1a2 2a1"));
    }

    @Test
    public void testIsPalindrome_alphanumericNonPalindrome() {
        assertFalse(solution.isPalindrome("1a2 3a1"));
    }

    @Test
    public void testIsPalindrome_allPunctuation() {
        assertTrue(solution.isPalindrome(".,!?;:"));
    }

    @Test
    public void testIsPalindrome_twoSameLetters() {
        assertTrue(solution.isPalindrome("aa"));
    }

    @Test
    public void testIsPalindrome_twoDifferentLetters() {
        assertFalse(solution.isPalindrome("ab"));
    }

    @Test
    public void testIsPalindrome_punctuationAroundPalindrome() {
        assertTrue(solution.isPalindrome("...level..."));
    }

    @Test
    public void testIsPalindrome_punctuationAroundNonPalindrome() {
        assertFalse(solution.isPalindrome("...hello..."));
    }

    @Test
    public void testIsPalindrome_evenLengthPalindrome() {
        assertTrue(solution.isPalindrome("abba"));
    }

    @Test
    public void testIsPalindrome_oddLengthPalindrome() {
        assertTrue(solution.isPalindrome("abcba"));
    }

    @Test
    public void testIsPalindrome_oneCharOff() {
        assertFalse(solution.isPalindrome("abca"));
    }

    @Test
    public void testIsPalindrome_upperCaseNonPalindrome() {
        assertFalse(solution.isPalindrome("RACE A CAR"));
    }
}
