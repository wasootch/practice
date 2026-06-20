package org.example.arrays;

import java.util.ArrayList;
import java.util.List;

///
/// 54. Spiral Matrix
/// Medium
///
/// Given an m x n matrix, return all elements of the matrix in spiral order.
///
/// Example 1:
/// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
/// Output: [1,2,3,6,9,8,7,4,5]
///
/// Example 2:
/// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
/// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
///
/// Constraints:
/// m == matrix.length
/// n == matrix[i].length
/// 1 <= m, n <= 10
/// -100 <= matrix[i][j] <= 100
///
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        getList(result, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);

        return result;
    }

    void getList(List<Integer> list, int[][] matrix, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) {
            return;
        }

        for (int i = left; i <= right; i++) {
            list.add(matrix[top][i]);
        }
        top++;

        for (int i = top; i <= bottom; i++) {
            list.add(matrix[i][right]);
        }
        right--;

        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        getList(list, matrix, top, bottom, left, right);
    }
}
