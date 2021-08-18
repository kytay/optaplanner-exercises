package org.sgdevcc.optaplanner.sudokusolver.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cell {

    // rowId - top-most = 0, bottom-most = 8
    private int rowId = -1;
    // columnId - left-most = 0, right-most = 8
    private int columnId = -1;
    // boxId - top-left = 0, bottom-right = 8
    private int boxId = -1;
    // initalValue - refers to given problem value
    private boolean initialValue = false;

    public Cell(int rowId, int columnId, boolean initialValue) {
        this.rowId = rowId;
        this.columnId = columnId;
        this.initialValue = initialValue;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public boolean isInitialValue() {
        return initialValue;
    }

    public void setInitialValue(boolean initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return new EqualsBuilder().append(rowId, cell.rowId).append(columnId, cell.columnId).append(initialValue, cell.initialValue).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(rowId).append(columnId).append(initialValue).toHashCode();
    }
}
