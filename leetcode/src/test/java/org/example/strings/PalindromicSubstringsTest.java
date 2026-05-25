package org.example.strings;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PalindromicSubstringsTest {

    private final PalindromicSubstrings solution = new PalindromicSubstrings();

    @Test
    public void testCountSubstrings_example1() {
        // "a","b","c","aba","aba"? No: "a","b","c","aba" — wait, "abc": singles only = 3
        assertEquals(solution.countSubstrings("abc"), 3);
    }

    @Test
    public void testCountSubstrings_example2() {
        // "a"x3 + "aa"x2 + "aaa" = 6
        assertEquals(solution.countSubstrings("aaa"), 6);
    }

    @Test
    public void testCountSubstrings_singleChar() {
        assertEquals(solution.countSubstrings("a"), 1);
    }

    @Test
    public void testCountSubstrings_twoSameChars() {
        // "a","a","aa" = 3
        assertEquals(solution.countSubstrings("aa"), 3);
    }

    @Test
    public void testCountSubstrings_twoDifferentChars() {
        // "a","b" only — no multi-char palindromes
        assertEquals(solution.countSubstrings("ab"), 2);
    }

    @Test
    public void testCountSubstrings_allSameChars() {
        // n chars all the same → n*(n+1)/2 palindromes
        assertEquals(solution.countSubstrings("aaaa"), 10);
        assertEquals(solution.countSubstrings("aaaaa"), 15);
    }

    @Test
    public void testCountSubstrings_entireStringIsPalindrome() {
        // "racecar": 7 singles + "cec" + "aceca" + "racecar" = 10
        assertEquals(solution.countSubstrings("racecar"), 10);
    }

    @Test
    public void testCountSubstrings_evenPalindromeEmbedded() {
        // "aab": "a","a","b","aa" = 4
        assertEquals(solution.countSubstrings("aab"), 4);
    }

    @Test
    public void testCountSubstrings_mixedOddAndEven() {
        // "abba": "a","b","b","a","bb","abba" = 6
        assertEquals(solution.countSubstrings("abba"), 6);
    }

    @Test
    public void testCountSubstrings_atLeastLengthForSingles() {
        // every string of length n has at least n palindromes (each single char)
        String[] inputs = {"abc", "xyz", "hello", "leetcode"};
        for (String s : inputs) {
            assertTrue(solution.countSubstrings(s) >= s.length(),
                    "Count should be at least " + s.length() + " for input \"" + s + "\"");
        }
    }
}
