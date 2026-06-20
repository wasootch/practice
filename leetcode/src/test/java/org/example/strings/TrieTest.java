package org.example.strings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TrieTest {

    private Trie trie;

    @BeforeMethod
    public void setUp() {
        trie = new Trie();
    }

    // --- Example from the problem ---

    @Test
    public void testExample1_fullSequence() {
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    // --- search ---

    @Test
    public void testSearch_emptyTrie() {
        assertFalse(trie.search("a"));
    }

    @Test
    public void testSearch_wordNotInserted() {
        trie.insert("hello");
        assertFalse(trie.search("world"));
    }

    @Test
    public void testSearch_exactWordFound() {
        trie.insert("hello");
        assertTrue(trie.search("hello"));
    }

    @Test
    public void testSearch_prefixIsNotWord() {
        // inserting "hello" does not make "hell" searchable
        trie.insert("hello");
        assertFalse(trie.search("hell"));
    }

    @Test
    public void testSearch_extensionIsNotWord() {
        // inserting "hell" does not make "hello" searchable
        trie.insert("hell");
        assertFalse(trie.search("hello"));
    }

    @Test
    public void testSearch_singleCharWord() {
        trie.insert("a");
        assertTrue(trie.search("a"));
    }

    @Test
    public void testSearch_singleCharNotInserted() {
        trie.insert("a");
        assertFalse(trie.search("b"));
    }

    @Test
    public void testSearch_multipleWordsSharePrefix() {
        trie.insert("apple");
        trie.insert("app");
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
    }

    @Test
    public void testSearch_insertDuplicate() {
        // inserting the same word twice should not break search
        trie.insert("hello");
        trie.insert("hello");
        assertTrue(trie.search("hello"));
    }

    @Test
    public void testSearch_longWord() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        trie.insert(word);
        assertTrue(trie.search(word));
        assertFalse(trie.search("abcdefghijklmnopqrstuvwxy")); // one char short
    }

    // --- startsWith ---

    @Test
    public void testStartsWith_emptyTrie() {
        assertFalse(trie.startsWith("a"));
    }

    @Test
    public void testStartsWith_exactWordIsOwnPrefix() {
        trie.insert("apple");
        assertTrue(trie.startsWith("apple"));
    }

    @Test
    public void testStartsWith_prefixMatch() {
        trie.insert("apple");
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("ap"));
        assertTrue(trie.startsWith("a"));
    }

    @Test
    public void testStartsWith_singleCharPrefix() {
        trie.insert("apple");
        assertTrue(trie.startsWith("a"));
    }

    @Test
    public void testStartsWith_noMatch() {
        trie.insert("apple");
        assertFalse(trie.startsWith("b"));
    }

    @Test
    public void testStartsWith_prefixLongerThanWord() {
        trie.insert("app");
        assertFalse(trie.startsWith("apple"));
    }

    @Test
    public void testStartsWith_sharesNoPrefix() {
        trie.insert("banana");
        assertFalse(trie.startsWith("apple"));
    }

    @Test
    public void testStartsWith_multipleWordsCommonPrefix() {
        trie.insert("apple");
        trie.insert("application");
        trie.insert("apply");
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("appl"));
        assertTrue(trie.startsWith("appli"));  // "application"
        assertTrue(trie.startsWith("apply"));  // exact word
    }

    @Test
    public void testStartsWith_wordInsertedAfterPrefixCheck() {
        assertFalse(trie.startsWith("dog"));
        trie.insert("dog");
        assertTrue(trie.startsWith("dog"));
        assertTrue(trie.startsWith("do"));
        assertTrue(trie.startsWith("d"));
    }

    // --- insert ---

    @Test
    public void testInsert_makesWordSearchable() {
        assertFalse(trie.search("cat"));
        trie.insert("cat");
        assertTrue(trie.search("cat"));
    }

    @Test
    public void testInsert_doesNotMakePrefixSearchable() {
        trie.insert("cat");
        assertFalse(trie.search("ca"));
        assertFalse(trie.search("c"));
    }

    @Test
    public void testInsert_makesPrefixAvailableViaStartsWith() {
        trie.insert("cat");
        assertTrue(trie.startsWith("ca"));
        assertTrue(trie.startsWith("c"));
    }

    @Test
    public void testInsert_multipleDistinctWords() {
        trie.insert("cat");
        trie.insert("dog");
        trie.insert("car");
        assertTrue(trie.search("cat"));
        assertTrue(trie.search("dog"));
        assertTrue(trie.search("car"));
        assertFalse(trie.search("ca"));
        assertFalse(trie.search("do"));
    }

    @Test
    public void testInsert_shorterWordAfterLonger() {
        // insert "apple" then "app" — "app" must then be a valid word
        trie.insert("apple");
        assertFalse(trie.search("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertTrue(trie.search("apple")); // still true
    }

    @Test
    public void testInsert_longerWordAfterShorter() {
        trie.insert("app");
        assertFalse(trie.search("apple"));
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app")); // still true
    }

    // --- combined scenarios ---

    @Test
    public void testCombined_searchAndStartsWithAfterManyInserts() {
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abcde");

        assertTrue(trie.search("abc"));
        assertTrue(trie.search("abcd"));
        assertTrue(trie.search("abcde"));
        assertFalse(trie.search("ab"));
        assertFalse(trie.search("abcdef"));

        assertTrue(trie.startsWith("a"));
        assertTrue(trie.startsWith("ab"));
        assertTrue(trie.startsWith("abc"));
        assertTrue(trie.startsWith("abcd"));
        assertTrue(trie.startsWith("abcde"));
        assertFalse(trie.startsWith("abcdef"));
    }

    @Test
    public void testCombined_noFalsePositivesAcrossBranches() {
        trie.insert("sea");
        trie.insert("see");
        trie.insert("sell");

        assertTrue(trie.search("sea"));
        assertTrue(trie.search("see"));
        assertTrue(trie.search("sell"));
        assertFalse(trie.search("se"));
        assertFalse(trie.search("sel"));

        assertTrue(trie.startsWith("se"));
        assertTrue(trie.startsWith("sel"));
        assertTrue(trie.startsWith("sea"));
        assertFalse(trie.startsWith("z"));
    }

    @Test
    public void testCombined_singleLetterWordsAllAlphabet() {
        for (char c = 'a'; c <= 'z'; c++) {
            trie.insert(String.valueOf(c));
        }
        for (char c = 'a'; c <= 'z'; c++) {
            assertTrue(trie.search(String.valueOf(c)));
            assertTrue(trie.startsWith(String.valueOf(c)));
        }
    }
}
