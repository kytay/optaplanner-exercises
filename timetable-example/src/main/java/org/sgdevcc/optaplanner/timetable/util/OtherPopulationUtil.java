package org.sgdevcc.optaplanner.timetable.util;

import org.sgdevcc.optaplanner.timetable.domain.Room;
import org.sgdevcc.optaplanner.timetable.domain.Timeslot;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OtherPopulationUtil {

    public static List<Room> populateRooms() {

        List<Room> listOfRooms = new ArrayList<>();

        for(int i = 0; i < 4; i++)
        {
            Room room = new Room("Room #" + i);
            listOfRooms.add(room);
        }

        return listOfRooms;
    }

    public static List<Timeslot> populateTimeslot() {

        List<Timeslot> listOfTimeSlots = new ArrayList<>();

        DayOfWeek startDayOfSchool = DayOfWeek.MONDAY;
        DayOfWeek endDayOfSchool = DayOfWeek.FRIDAY;
        LocalTime startOfSchool = LocalTime.of(8, 0);
        LocalTime endOfSchool = LocalTime.of(12, 0);

        DayOfWeek currentDayCursor = startDayOfSchool;
        do {
            for(LocalTime timeCursor = startOfSchool; timeCursor.isBefore(endOfSchool); timeCursor = timeCursor.plusHours(1))
            {
                Timeslot timeSlot = new Timeslot(currentDayCursor, timeCursor, timeCursor.plusHours(1));
                listOfTimeSlots.add(timeSlot);
            }
            currentDayCursor = currentDayCursor.plus(1);
        } while(currentDayCursor.getValue() <= endDayOfSchool.getValue());

        return listOfTimeSlots;
    }
}
