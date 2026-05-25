package org.example.arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n <= 1) return;

        int k = n - 1;

        for (int i = 0; i < (n >> 1); i++) {
            for (int j = i; j < k - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[k - j][i];
                matrix[k - j][i] = matrix[k - i][k - j];
                matrix[k - i][k - j] = matrix[j][k - i];
                matrix[j][k - i] = tmp;
            }
        }
    }
}
