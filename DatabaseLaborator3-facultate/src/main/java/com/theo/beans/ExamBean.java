package com.theo.beans;

import com.theo.config.JPAConfig;
import com.theo.entities.ExamEntity;
import com.theo.repositories.ExamRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "examBean")
@ApplicationScoped
public class ExamBean {
    private ExamRepository examRepo;

    public ExamBean() {
        JPAConfig jpaConfig = new JPAConfig();
        examRepo = new ExamRepository(jpaConfig.createEM());
    }

    public void getAllExams() {
        List<ExamEntity> exams = examRepo.getAll();
        System.out.println("Printing all exams");
        for (ExamEntity exam : exams) {
            System.out.println(exam.getName());
        }
    }

    public void insertExam() {
        ExamEntity exam = new ExamEntity();
        exam.setName("newExam");
        exam.setDuration("120");
        exam.setStartingtime("12:00");
        examRepo.save(exam);
    }

    public void getByName() {
        examRepo.getByName();
    }

}
