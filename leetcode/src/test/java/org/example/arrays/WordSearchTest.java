package org.example.arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordSearchTest {

    private WordSearch solution;
    private char[][] board;

    @BeforeMethod
    public void setUp() {
        solution = new WordSearch();
        board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
    }

    @Test
    public void testExample1_ABCCED_returnsTrue() {
        assertTrue(solution.exist(board, "ABCCED"));
    }

    @Test
    public void testExample2_SEE_returnsTrue() {
        assertTrue(solution.exist(board, "SEE"));
    }

    @Test
    public void testExample3_ABCB_returnsFalse() {
        assertFalse(solution.exist(board, "ABCB"));
    }

    @Test
    public void testSingleLetterExists() {
        assertTrue(solution.exist(board, "A"));
    }

    @Test
    public void testSingleLetterNotExists() {
        assertFalse(solution.exist(board, "Z"));
    }

    @Test
    public void testWordRequiresSameCellTwice_returnsFalse() {
        char[][] small = {{'A', 'A'}};
        assertFalse(solution.exist(small, "AAA"));
    }

    @Test
    public void testSingleCellBoardMatch() {
        char[][] single = {{'X'}};
        assertTrue(solution.exist(single, "X"));
    }

    @Test
    public void testSingleCellBoardNoMatch() {
        char[][] single = {{'X'}};
        assertFalse(solution.exist(single, "Y"));
    }
}