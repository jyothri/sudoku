package com.jkurapati.sudoku.solve;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Represents a sudoku board.
 */
public final class Board {
    private static final int SUDOKU_DIMENSION = 3;
    private static final int SQUARE_OF_DIMENSION = SUDOKU_DIMENSION * SUDOKU_DIMENSION;

    private final int[][] matrix = new int[SQUARE_OF_DIMENSION][SQUARE_OF_DIMENSION];
    private final List<Observable> listeners = new ArrayList<>();
    private final ExecutorService exec;

    public Board() {
        exec = Executors.newCachedThreadPool();
    }

    /**
     * Add a listener to be notified when a cell value is set.
     * <p> Notification happens async without blocking the main program.
     * @param observable the object to be notified.
     */
    public void registerListener(Observable observable) {
        listeners.add(observable);
    }

    public void setCellValue(int row, int col, int val) {
        matrix[row][col] = val;
        notifyListeners(row, col, val);
    }

    public int getCellValue(int row, int col) {
        return matrix[row][col];
    }

    /**
     *
     * @return a (deep) copy of the underlying matrix.
     */
    public int[][] getMatrix() {
        return deepCopy(matrix);
    }

    private void notifyListeners(int row, int col, int val) {
        for (Observable observable : listeners) {
            exec.submit(() -> observable.notifyChange(row, col, val));
        }
    }

    private static int[][] deepCopy(int[][] arrayToCopy) {
        if (arrayToCopy == null || arrayToCopy.length == 0) {
            throw new ArrayStoreException("Cannot do deep copy on empty array.");
        }
        int[][] arrayCopy = new int[arrayToCopy.length][arrayToCopy[0].length];
        for (int i = 0; i < arrayToCopy.length; i++) {
            for (int j = 0; j < arrayToCopy[i].length; j++) {
                arrayCopy[i][j] = arrayToCopy[i][j];
            }
        }
        return arrayCopy;
    }
}
