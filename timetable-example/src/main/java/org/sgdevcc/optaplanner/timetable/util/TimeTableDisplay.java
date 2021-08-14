package org.sgdevcc.optaplanner.timetable.util;

import org.sgdevcc.optaplanner.timetable.domain.Lesson;
import org.sgdevcc.optaplanner.timetable.domain.Room;
import org.sgdevcc.optaplanner.timetable.domain.TimeTable;
import org.sgdevcc.optaplanner.timetable.domain.Timeslot;

import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTableDisplay {

    public static void printByRoom(TimeTable timeTable) {

        Map<Room, Map<Timeslot, Lesson>> tableByRoom = new HashMap<>();

        List<Timeslot> timeslotList = timeTable.getTimeslotList();
        timeslotList.sort(new Comparator<Timeslot>() {
            @Override
            public int compare(Timeslot timeslot, Timeslot t1) {

                if(timeslot.getDayOfWeek() == t1.getDayOfWeek())
                {
                    return timeslot.getStartTime().compareTo(t1.getStartTime());
                }
                else
                {
                    return timeslot.getDayOfWeek().compareTo(t1.getDayOfWeek());
                }

//                if(timeslot.getStartTime() == t1.getStartTime())
//                {
//                    return timeslot.getDayOfWeek().compareTo(t1.getDayOfWeek());
//                }
//                else
//                {
//                    return timeslot.getStartTime().compareTo(t1.getStartTime());
//                }
            }
        });

        List<Room> roomList = timeTable.getRoomList();
        roomList.sort(new Comparator<Room>() {
            @Override
            public int compare(Room room, Room t1) {
                return room.getName().compareTo(t1.getName());
            }
        });

        for(Room room: roomList)
        {
            Map<Timeslot, Lesson> lessonTime = new HashMap<>();
            for(Timeslot timeslot: timeslotList)
            {
                lessonTime.put(timeslot, null);
            }

            tableByRoom.put(room, lessonTime);
        }

        List<Lesson> scheduledLessonList = timeTable.getLessonList();

        for(Lesson scheduledLesson: scheduledLessonList)
        {
            Map<Timeslot, Lesson> lessonStack = tableByRoom.get(scheduledLesson.getRoom());
            lessonStack.put(scheduledLesson.getTimeslot(), scheduledLesson);
        }

        // print

        for(Room room: roomList)
        {
            DayOfWeek currentCursor = null;
            System.out.println("Room: " + room.toString());

            Map<Timeslot, Lesson> lessonStack = tableByRoom.get(room);
            for(Timeslot timeslot: timeslotList)
            {
                Lesson tmpLesson = lessonStack.get(timeslot);
                if(tmpLesson == null)
                    continue;
                else {
                    if(timeslot.getDayOfWeek() != currentCursor) {
                        System.out.println("Day: " + timeslot.getDayOfWeek().toString());
                        currentCursor = timeslot.getDayOfWeek();
                    }
                    System.out.println(tmpLesson.toString());
                }
            }
        }

        System.out.println();
    }

    public void printByTeacher(TimeTable timeTable) {

    }
}
