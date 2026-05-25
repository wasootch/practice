package org.example.arrays;

/// [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/?envType=problem-list-v2&envId=oizxjoit)
/// Medium
/// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
///
/// You must do it in place.
///
///
///
/// Example 1:
///
///
/// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
/// Output: [[1,0,1],[0,0,0],[1,0,1]]
/// Example 2:
///
///
/// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
/// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
///
///
/// Constraints:
///
/// m == matrix.length
/// n == matrix[0].length
/// 1 <= m, n <= 200
/// -231 <= matrix[i][j] <= 231 - 1
///
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean colZeroZeroed = false;
        boolean rowZeroZeroed = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) colZeroZeroed = true;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) rowZeroZeroed = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                boolean rowMarked = (i == 0) ? rowZeroZeroed : matrix[i][0] == 0;
                if (rowMarked || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (colZeroZeroed) {
                matrix[i][0] = 0;
            }
        }
    }
}
