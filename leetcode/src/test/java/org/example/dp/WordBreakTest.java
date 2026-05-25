package org.example.dp;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class WordBreakTest {

    WordBreak solution = new WordBreak();

    @Test
    public void testWordBreak_base() {
        assertTrue(solution.wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(solution.wordBreak("applepenapple", List.of("apple", "pen")));
        assertFalse(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void testWordBreak_CatsAndDogs() {
        assertFalse(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void testWordBreak_Cars() {
        assertTrue(solution.wordBreak("cars", List.of("car", "ca", "rs")));
    }

    @Test
    public void testWordBreak_aaa() {
        assertFalse(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
