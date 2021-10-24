package com.theo.lab3final;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.Duration;
import java.time.LocalTime;

@ManagedBean
@RequestScoped
public class Exam {
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
