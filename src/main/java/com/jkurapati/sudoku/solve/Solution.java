package com.jkurapati.sudoku.solve;

class Solution {
    private static final int SUDOKU_DIMENSION = 3;

    private Board board;

    public void solve() {
        if (board == null || board.getMatrix() == null) {
            throw new IllegalArgumentException("Invalid board to solve.");
        }
        int[][] matrix = board.getMatrix();
        int squareOfDimension = SUDOKU_DIMENSION * SUDOKU_DIMENSION;
        if (matrix.length != squareOfDimension || matrix[0].length != squareOfDimension) {
            throw new IllegalArgumentException("Unsupported dimensions of the board.");
        }

        // TODO: Implement rest of logic.
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
