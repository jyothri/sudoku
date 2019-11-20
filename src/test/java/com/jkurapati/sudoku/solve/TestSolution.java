package com.jkurapati.sudoku.solve;

import org.junit.Test;

public class TestSolution {

    @Test(expected = IllegalArgumentException.class)
    public void invalidboard_throwIllegalArgException() {
        new Solution().solve();
    }
}
