package com.theo.beans;

import com.theo.config.JPAConfig;
import com.theo.entities.StudentEntity;
import com.theo.repositories.StudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name="studentBean")
@ApplicationScoped
public class StudentBean {
    private StudentRepository studentRepo;

    public StudentBean() {
        JPAConfig jpaConfig = new JPAConfig();
        studentRepo = new StudentRepository(jpaConfig.createEM());
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
