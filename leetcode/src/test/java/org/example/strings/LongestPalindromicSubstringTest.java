package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    @Test
    public void testLongestPalindrome_example1() {
        // "bab" and "aba" are both valid; this implementation returns the first found
        String result = solution.longestPalindrome("babad");
        assertEquals(result.length(), 3);
        assertTrue(isPalindrome(result));
        assertTrue("babad".contains(result));
    }

    @Test
    public void testLongestPalindrome_example2() {
        assertEquals(solution.longestPalindrome("cbbd"), "bb");
    }

    @Test
    public void testLongestPalindrome_singleChar() {
        assertEquals(solution.longestPalindrome("a"), "a");
    }

    @Test
    public void testLongestPalindrome_twoSameChars() {
        assertEquals(solution.longestPalindrome("aa"), "aa");
    }

    @Test
    public void testLongestPalindrome_twoDifferentChars() {
        // no palindrome longer than 1; returns first character
        assertEquals(solution.longestPalindrome("ab"), "a");
    }

    @Test
    public void testLongestPalindrome_entireStringIsOddPalindrome() {
        assertEquals(solution.longestPalindrome("racecar"), "racecar");
    }

    @Test
    public void testLongestPalindrome_entireStringIsEvenPalindrome() {
        assertEquals(solution.longestPalindrome("abba"), "abba");
    }

    @Test
    public void testLongestPalindrome_allSameChars() {
        assertEquals(solution.longestPalindrome("aaaa"), "aaaa");
    }

    @Test
    public void testLongestPalindrome_noPalindromeGtOne() {
        // all characters distinct — answer is the first character
        String result = solution.longestPalindrome("abcde");
        assertEquals(result.length(), 1);
        assertTrue(isPalindrome(result));
    }

    @Test
    public void testLongestPalindrome_palindromeInMiddle() {
        // "racecar" is embedded; surrounding chars don't extend it
        assertEquals(solution.longestPalindrome("xracecarx"), "xracecarx");
    }

    @Test
    public void testLongestPalindrome_palindromeAtEnd() {
        String result = solution.longestPalindrome("abcmadam");
        assertEquals(result, "madam");
    }

    @Test
    public void testLongestPalindrome_evenPalindromeEmbedded() {
        // "abba" is inside but "aabbaa" is longer
        assertEquals(solution.longestPalindrome("xaabbaa"), "aabbaa");
    }

    @Test
    public void testLongestPalindrome_resultIsAlwaysAPalindrome() {
        String[] inputs = {"babad", "cbbd", "racecar", "abcba", "aabbaa", "aaaa", "abcd"};
        for (String s : inputs) {
            String result = solution.longestPalindrome(s);
            assertTrue(isPalindrome(result), "Not a palindrome for input \"" + s + "\": \"" + result + "\"");
            assertTrue(s.contains(result), "Result is not a substring of input");
        }
    }
}
