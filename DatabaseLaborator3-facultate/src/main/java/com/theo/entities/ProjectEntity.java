package com.theo.entities;


import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class ProjectEntity extends ExamEntity {
    @Column(name = "duedate", length = 40)
    private String dueDate;
    @Column(name = "teamsize")
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
