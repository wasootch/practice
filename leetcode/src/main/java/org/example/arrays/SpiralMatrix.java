package org.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        getList(result, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);

        return result;
    }

    void getList(List<Integer> list, int[][] matrix, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) return;

        for (int i = left; i <= right; i++) list.add(matrix[top][i]);
        top++;

        for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
        right--;

        if (top <= bottom) {
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            left++;
        }

        getList(list, matrix, top, bottom, left, right);
    }
}
