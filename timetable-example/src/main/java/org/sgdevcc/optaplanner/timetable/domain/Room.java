package org.sgdevcc.optaplanner.timetable.domain;

public class Room {

    private String name;

    public Room() {
        // stub
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
