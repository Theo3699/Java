package com.theo.entities;

import com.theo.databaselaborator3facultate.Exam;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class ProjectEntity extends Exam {
    private String dueDate;
    private int teamSize;

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
