package com.theo.lab3final;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class Student {
    private String name;
    private List<Exam> exams;

    public Student() {
        exams = new ArrayList<>();
    }

    public Student(String name, List<Exam> exams) {
        this.name = name;
        this.exams = exams;
    }

    public String getName() {
        return name;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void tryConnection(){
        Database database = new Database();
        System.out.println(database.connect());
    }
}
