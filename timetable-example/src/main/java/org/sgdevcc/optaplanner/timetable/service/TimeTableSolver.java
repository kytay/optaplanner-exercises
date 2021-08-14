package org.sgdevcc.optaplanner.timetable.service;

import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.sgdevcc.optaplanner.timetable.domain.TimeTable;
import org.sgdevcc.optaplanner.timetable.util.LessonPopulationUtil;
import org.sgdevcc.optaplanner.timetable.util.OtherPopulationUtil;
import org.sgdevcc.optaplanner.timetable.util.TimeTableDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class TimeTableSolver {

    @Autowired
    public TimeTableSolver(SolverManager<TimeTable, UUID> solverManager) {

        TimeTable myTimeTable = new TimeTable();
        myTimeTable.setLessonList(LessonPopulationUtil.populateLessons());
        myTimeTable.setRoomList(OtherPopulationUtil.populateRooms());
        myTimeTable.setTimeslotList(OtherPopulationUtil.populateTimeslot());

        SolverJob<TimeTable, UUID> solverJob = solverManager.solve(UUID.randomUUID(), myTimeTable);
        TimeTable mySolution = new TimeTable();

        try {
            mySolution = solverJob.getFinalBestSolution();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        TimeTableDisplay.printByRoom(mySolution);

        System.out.println();
    }
}
