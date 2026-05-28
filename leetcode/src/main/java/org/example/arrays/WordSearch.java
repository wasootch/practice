package org.example.arrays;

import java.util.Arrays;

/// [79. Word Search](https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=oizxjoit)
/// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
///
/// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
///
/// Example 1:
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
/// Output: true
///
/// Example 2:
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
/// Output: true
///
/// Example 3:
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
/// Output: false
///
/// Constraints:
/// m == board.length
/// n = board[i].length
/// 1 <= m, n <= 6
/// 1 <= word.length <= 15
/// board and word consists of only lowercase and uppercase English letters.
///
/// Follow up: Could you use search pruning to make your solution faster with a larger board?
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (test(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    boolean test(char[][] board, String word, int row, int col, int i, boolean[][] visited) {
        if (i == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (word.charAt(i) == board[row][col]) {
            if (test(board, word, row + 1, col, i + 1, visited)
                    || test(board, word, row, col + 1, i + 1, visited)
                    || test(board, word, row - 1, col, i + 1, visited)
                    || test(board, word, row, col - 1, i + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
