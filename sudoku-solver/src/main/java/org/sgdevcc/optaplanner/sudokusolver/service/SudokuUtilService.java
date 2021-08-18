package org.sgdevcc.optaplanner.sudokusolver.service;

import org.sgdevcc.optaplanner.sudokusolver.domain.Sudoku;

public interface SudokuUtilService {

    /**
     * Build the Sudoku problem, based on the given cell values.
     * Expect cellValues array size to be 81. Top-Left = 0, Bottom-Right = 80
     * Each cellValue should be between 1 and 9, any other value is treated as invalid value
     * @param cellValue
     * @return
     */
    Sudoku buildSudokuProblem(int[] cellValue);
}
