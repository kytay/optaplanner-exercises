package org.sgdevcc.optaplanner.timetable.util;

import org.sgdevcc.optaplanner.timetable.domain.Lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LessonPopulationUtil {

    private static String[] subjects = new String[]{
            "History",      // 0
            "Geography",    // 1
            "Chinese",      // 2
            "English",      // 3
            "E.Maths",      // 4
            "A.Maths",      // 5
            "Physics",      // 6
            "Chemistry",    // 7
            "Biography"     // 8
    };

    private static String[] teachers = new String[] {
            "Mr. Koh K.H",
            "Ms. Liew S.Y",
            "Ms. Lee H.X",
            "Ms. Chia W.P",
            "Ms. Padma D.",
            "Mr. Zaw M.T",
            "Ms. Ng H.P",
            "Mr. Tew T.H",
            "Ms. Katty",
            "Mr. Aw",
            "Mr. Pang"
    };

    private static int[][] teacherToLessonsPerWeek = new int[][] {
            {7, 7, 7, 7, 7, 7, 6, 6}, // Mr. Koh K.H - 6x chemistry, and 2x physics
            {4, 4, 4, 5, 5, 5, 3, 3}, // Ms. Liew S.Y - 3x E.Maths, 3x A.Maths, and 2x english
            {4, 4, 4, 4, 5, 5, 5, 5}, // Ms. Lee
            {3, 3, 3, 3, 7, 7, 8, 8}, // Ms. Chia
            {0, 0, 0, 0, 0, 0, 0, 0}, // Ms. Padma
            {1, 1, 1, 1, 1, 1, 1, 1}, // Mr. Zaw
            {8, 8, 8, 8, 8, 1, 1, 0}, // Ms. Ng
            {6, 6, 6, 7, 7, 7, 8, 8}, // Mr. Tew
            {3, 3, 3, 3, 3, 3, 3, 3}, // Ms. Katty
            {2, 2, 2, 2, 0, 0, 0, 0}, // Mr. Aw
            {2, 2, 2, 2, 2, 2, 2, 2}  // Mr. Pang
    };

    private static String[] classes = new String[] {
            "Class 1A",
            "Class 1B",
            "Class 1C",
            "Class 1D",
            "Class 1E",
            "Class 1F"
    };

    public static List<Lesson> populateLessons() {

        List<Lesson> listOfLessons = new ArrayList<>();

        long lessonId = 0;
        int classCursorIndex = 0;

        for(int tIndex = 0; tIndex < LessonPopulationUtil.teachers.length; tIndex++)
        {
            for(int subCursor = 0; subCursor < LessonPopulationUtil.teacherToLessonsPerWeek[tIndex].length; subCursor++)
            {
                int subIndex = LessonPopulationUtil.teacherToLessonsPerWeek[tIndex][subCursor];
                String teacher = LessonPopulationUtil.teachers[tIndex];
                String subject = LessonPopulationUtil.subjects[subIndex];
                String studentGroup = LessonPopulationUtil.classes[classCursorIndex];

                Lesson lesson = new Lesson(lessonId, subject, teacher, studentGroup, null, null);
                listOfLessons.add(lesson);

                if(classCursorIndex + 1 < LessonPopulationUtil.classes.length)
                    classCursorIndex++;
                else
                    classCursorIndex = 0;

                lessonId++;
            }
        }

        return listOfLessons;
    }
}
