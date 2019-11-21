package com.jkurapati.sudoku.solve;

import org.junit.Test;

import java.util.Arrays;

public class TestSolution {

    @Test(expected = IllegalArgumentException.class)
    public void invalidboard_throwIllegalArgException() {
        new Solution().solve();
    }

    @Test
    public void validboard_solves() {
        Solution solution = new Solution();
        Board board = new Board();
        int[][] matrix = new int[][]{
                {9, 0, 0, 0, 6, 0, 0, 7, 0},
                {8, 0, 0, 2, 0, 5, 0, 4, 0},
                {0, 5, 0, 0, 3, 0, 2, 0, 0},
                {3, 0, 8, 1, 0, 0, 6, 5, 9},
                {0, 0, 0, 8, 4, 6, 0, 0, 0},
                {6, 2, 7, 0, 0, 9, 4, 0, 8},
                {0, 0, 3, 0, 9, 0, 0, 2, 0},
                {0, 6, 0, 5, 0, 1, 0, 0, 7},
                {0, 8, 0, 0, 2, 0, 0, 0, 4}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                board.setCellValue(i, j, matrix[i][j]);
            }
        }
        board.registerListener((row, col, val) -> matrix[row][col] = val);
        solution.setBoard(board);
        printMatrix(matrix);
        solution.solve();
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
