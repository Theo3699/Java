package com.theo.databaselaborator3facultate;

import com.theo.entities.AbstractEntity;

public class Exam extends AbstractEntity<String> {
    private String name;
    private String startingTime;
    private String minutes;

    public Exam() {
    }

    public Exam(String name, String startingTime, String minutes) {
        this.name = name;
        this.startingTime = startingTime;
        this.minutes = minutes;
    }

    public Exam(String s, String name, String startingTime, String minutes) {
        super(s);
        this.name = name;
        this.startingTime = startingTime;
        this.minutes = minutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public String getMinutes() {
        return minutes;
    }
}
