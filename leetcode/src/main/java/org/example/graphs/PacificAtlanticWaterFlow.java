package org.example.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dps(heights, pacific, i, 0);
            dps(heights, atlantic, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dps(heights, pacific, 0, i);
            dps(heights, atlantic, n - 1, i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    void dps(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        if (row < heights.length - 1 && heights[row][col] <= heights[row + 1][col]) {
            dps(heights, visited, row + 1, col);
        }
        if (row > 0 && heights[row][col] <= heights[row - 1][col]) {
            dps(heights, visited, row - 1, col);
        }
        if (col < heights[0].length - 1 && heights[row][col] <= heights[row][col + 1]) {
            dps(heights, visited, row, col + 1);
        }
        if (col > 0 && heights[row][col] <= heights[row][col - 1]) {
            dps(heights, visited, row, col - 1);
        }
    }
}
