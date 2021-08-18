package org.sgdevcc.optaplanner.sudokusolver.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import java.util.List;

@PlanningSolution
public class Sudoku {

    @ValueRangeProvider(id = "cellRange")
    @ProblemFactCollectionProperty
    private List<Cell> cellList;

    @PlanningEntityCollectionProperty
    private List<CellValueAssignment> cellValueAssignmentList;

    @PlanningScore
    private SimpleScore score;

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public List<CellValueAssignment> getCellValueAssignmentList() {
        return cellValueAssignmentList;
    }

    public void setCellValueAssignmentList(List<CellValueAssignment> cellValueAssignmentList) {
        this.cellValueAssignmentList = cellValueAssignmentList;
    }

    public SimpleScore getScore() {
        return score;
    }

    public void setScore(SimpleScore score) {
        this.score = score;
    }
}
