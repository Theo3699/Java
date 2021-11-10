package com.theo.repositories;


import com.theo.databaselaborator3facultate.Exam;
import com.theo.entities.ExamEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ExamRepository extends DataRepository<ExamEntity, Integer> {

    @Inject
    public ExamRepository(EntityManager em) {
        this.examManagerPU = em;
    }

    @Override
    public ExamEntity getById(Integer s) {
        return null;
    }

    @Override
    public void updateEntities(List<ExamEntity> entities) {
        for (ExamEntity exam : entities) {
            save(exam);
        }
    }

    @Override
    public List<ExamEntity> getAll() {
        Query query = examManagerPU.createNamedQuery("Exam.findAll");
        List<ExamEntity> exams = ((Collection<ExamEntity>) query.getResultList()).stream().collect(Collectors.toList());
        return exams;
    }

    @Override
    public void save(ExamEntity exam) {
        examManagerPU.getTransaction().begin();
        examManagerPU.persist(exam);
        examManagerPU.getTransaction().commit();
        System.out.println("Exams database updated!");
    }

    @Override
    public void getByName() {
        Query query = examManagerPU.createNamedQuery("Exam.findByName");
        query.setParameter("name", "java");
        Collection examResults = query.getResultList();
        for (Object exam : examResults) {
            System.out.println("GetByName(): " + ((ExamEntity) exam).getName());
        }
        examManagerPU.close();
    }
}
