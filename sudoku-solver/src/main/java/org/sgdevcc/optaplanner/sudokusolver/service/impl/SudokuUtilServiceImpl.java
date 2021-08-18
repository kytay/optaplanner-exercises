package org.sgdevcc.optaplanner.sudokusolver.service.impl;

import org.sgdevcc.optaplanner.sudokusolver.domain.Sudoku;
import org.sgdevcc.optaplanner.sudokusolver.service.SudokuUtilService;

public class SudokuUtilServiceImpl implements SudokuUtilService {

    @Override
    public Sudoku buildSudokuProblem(int[] cellValue) {

        if(cellValue.length > 81) {}

        return null;
    }
}
