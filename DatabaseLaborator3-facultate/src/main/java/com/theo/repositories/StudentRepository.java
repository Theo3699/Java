package com.theo.repositories;

import com.theo.entities.ExamEntity;
import com.theo.entities.StudentEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository extends DataRepository<StudentEntity, Integer> {

    @Inject
    public StudentRepository(EntityManager em) {
        this.examManagerPU = em;
    }

    @Override
    public StudentEntity getById(Integer integer) {
        return null;
    }

    @Override
    public void updateEntities(List<StudentEntity> entities) {
        for (StudentEntity exam : entities) {
            save(exam);
        }
    }

    @Override
    public List<StudentEntity> getAll() {
        Query query = examManagerPU.createNamedQuery("Student.findAll");
        List<StudentEntity> students = ((Collection<StudentEntity>) query.getResultList()).stream().collect(Collectors.toList());
        return students;
    }

    @Override
    public void save(StudentEntity studentEntity) {
        examManagerPU.getTransaction().begin();
        examManagerPU.persist(studentEntity);
        examManagerPU.getTransaction().commit();
        System.out.println("Students database updated!");
    }

    @Override
    public void getByName() {
        Query query = examManagerPU.createNamedQuery("Student.findByName");
        query.setParameter("name", "Theodor Samson");
        Collection studentResults = query.getResultList();
        for (Object student : studentResults) {
            System.out.println("GetByName(): " + ((StudentEntity) student).getName());
        }
        examManagerPU.close();
    }
}
