package com.theo.lab3final;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class Student {
    private String name;
    private String examName;

    public Student() {
    }

    public Student(String name, String exam) {
        this.name = name;
        this.examName = exam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExam(String exam) {
        this.examName = exam;
    }

    public String getName() {
        return name;
    }

    public String getExam() {
        return examName;
    }
}
