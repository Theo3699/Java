package com.theo.lab3final;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class DtSelectionView {

    private List<Student> students;
    private List<Exam> exams;

    @Inject
    private Database database;

    @PostConstruct
    public void init(){
        exams = database.getExams();
        students = database.getStudents();
    }

    public List<Exam> getExams(){
        return exams;
    }

    public List<Student> getStudents(){
        return students;
    }
}
