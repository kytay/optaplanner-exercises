package org.sgdevcc.optaplanner.sudokusolver.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class CellValueAssignment {

    @PlanningVariable(valueRangeProviderRefs = "cellRange")
    private Cell cell = null;
    // Sudoku Value - 1 to 9
    private int value = 0;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
