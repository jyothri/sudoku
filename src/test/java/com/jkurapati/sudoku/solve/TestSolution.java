package com.jkurapati.sudoku.solve;

import org.junit.Assert;
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

        int[][] expected = new int[][]{
                {9, 3, 2, 4, 6, 8, 5, 7, 1},
                {8, 7, 6, 2, 1, 5, 9, 4, 3},
                {4, 5, 1, 9, 3, 7, 2, 8, 6},
                {3, 4, 8, 1, 7, 2, 6, 5, 9},
                {1, 9, 5, 8, 4, 6, 7, 3, 2},
                {6, 2, 7, 3, 5, 9, 4, 1, 8},
                {7, 1, 3, 6, 9, 4, 8, 2, 5},
                {2, 6, 4, 5, 8, 1, 3, 9, 7},
                {5, 8, 9, 7, 2, 3, 1, 6, 4}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                board.setCellValue(i, j, matrix[i][j]);
            }
        }
        board.registerListener((row, col, val) -> matrix[row][col] = val);
        solution.setBoard(board);
        solution.solve();
        verifyMatrixEquals(matrix, expected);

    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void verifyMatrixEquals(int[][] actual, int[][] expected) {
        Assert.assertEquals(actual.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i]);
        }
    }
}
