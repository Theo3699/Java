package com.theo.beans;

import com.theo.config.JPAConfig;
import com.theo.entities.ExamEntity;
import com.theo.repositories.ExamRepository;
import com.theo.repositories.StudentRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "examBean")
@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ExamBean {

    @EJB
    private ExamRepository examRepo;

    @PostConstruct
    public void init() {
        JPAConfig jpaConfig = new JPAConfig();
        examRepo = new ExamRepository(jpaConfig.createEM());
        System.out.println("ExamBean: init'ed");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ExamBean: destroyed");
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
