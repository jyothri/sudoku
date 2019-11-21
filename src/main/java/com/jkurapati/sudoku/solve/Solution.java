package com.jkurapati.sudoku.solve;

import java.util.Arrays;

class Solution {
    private static final int SUDOKU_DIMENSION = 3;
    private static final int SQUARE_OF_DIMENSION = SUDOKU_DIMENSION * SUDOKU_DIMENSION;

    private Board board;

    public void solve() {
        if (board == null || board.getMatrix() == null) {
            throw new IllegalArgumentException("Invalid board to solve.");
        }
        int[][] matrix = board.getMatrix();

        if (matrix.length != SQUARE_OF_DIMENSION || matrix[0].length != SQUARE_OF_DIMENSION) {
            throw new IllegalArgumentException("Unsupported dimensions of the board.");
        }

        backtrack();
    }

    private void backtrack() {
        int[][] matrix = board.getMatrix();
        backtrackHelper(matrix, 0, 0);
    }

    private boolean backtrackHelper(int[][] matrix, int rowPos, int colPos) {
        if (rowPos == SQUARE_OF_DIMENSION || colPos == SQUARE_OF_DIMENSION) {
            return true;
        }

        int nextRowPos = rowPos + (colPos + 1) / SQUARE_OF_DIMENSION;
        int nextColPos = (colPos + 1) % SQUARE_OF_DIMENSION;
        if (matrix[rowPos][colPos] == 0) {
            for (int i = 1; i < (SQUARE_OF_DIMENSION + 1); i++) {
                matrix[rowPos][colPos] = i;
                board.setCellValue(rowPos, colPos, i);
                if (valid(matrix, rowPos, colPos)) {
                    if (backtrackHelper(matrix, nextRowPos, nextColPos)) {
                        return true;
                    }
                }
            }
            matrix[rowPos][colPos] = 0;
            board.setCellValue(rowPos, colPos, 0);
            return false;
        }
        return backtrackHelper(matrix, nextRowPos, nextColPos);
    }

    private boolean valid(int[][] matrix, int row, int col) {
        int len = matrix.length;
        boolean[] mask = new boolean[len + 1];
        //Check Row
        Arrays.fill(mask, false);
        for (int i = 0; i < len; i++) {
            int cellValue = matrix[row][i];
            if (cellValue != 0) {
                if (mask[cellValue]) {
                    return false;
                }
                mask[cellValue] = true;
            }
        }

        //Check Column
        Arrays.fill(mask, false);
        for (int i = 0; i < len; i++) {
            int cellValue = matrix[i][col];
            if (cellValue != 0) {
                if (mask[cellValue]) {
                    return false;
                }
                mask[cellValue] = true;
            }
        }

        //Check block
        Arrays.fill(mask, false);
        int rowBegin = row / SUDOKU_DIMENSION;    // 0,1,2 / 3 = 0;  3,4,5 / 3 = 1; etc
        int colBegin = row / SUDOKU_DIMENSION;
        for (int i = rowBegin; i < (rowBegin + SUDOKU_DIMENSION); i++) {
            for (int j = colBegin; j < (colBegin + SUDOKU_DIMENSION); j++) {
                int cellValue = matrix[i][j];
                if (cellValue != 0) {
                    if (mask[cellValue]) {
                        return false;
                    }
                    mask[cellValue] = true;
                }
            }
        }
        return true;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
