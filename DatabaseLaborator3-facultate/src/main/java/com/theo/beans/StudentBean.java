package com.theo.beans;

import com.theo.config.JPAConfig;
import com.theo.entities.StudentEntity;
import com.theo.repositories.StudentRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name="studentBean")
@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StudentBean {

    @EJB
    private StudentRepository studentRepo;

    @PostConstruct
    public void init() {
        JPAConfig jpaConfig = new JPAConfig();
        studentRepo = new StudentRepository(jpaConfig.createEM());
        System.out.println("StudentBean: init'ed");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("StudentBean: destroyed");
    }

    public void getAllStudents() {
        List<StudentEntity> students = studentRepo.getAll();
        System.out.println("Printing all students");
        for (StudentEntity student : students) {
            System.out.println(student.getName());
        }
    }

    public void insertStudent() {
        StudentEntity student = new StudentEntity();
        student.setName("newName");
        student.setExamname("newExam");
        studentRepo.save(student);
    }

    public void getByName() {
        studentRepo.getByName();
    }

}
