package com.jkurapati.sudoku.solve;

/**
 * java.util.Observable has been deprecated and the replacements seem to be heavy-weight.
 * Could not figure out a simple way to import java.beans.Observable which is in the
 * module java.desktop.
 * <p>
 * This is a simple replacement which has a single method which would be invoked to notify listeners.
 */
@FunctionalInterface
public interface Observable {
    /**
     * method that would be invoked when a cell value is set on the board.
     *
     * @param row the row of the cell where value was updated
     * @param col the column of the cell where value was updated
     * @param val the new value. 0 means unset.
     */
    void notifyChange(int row, int col, int val);
}
