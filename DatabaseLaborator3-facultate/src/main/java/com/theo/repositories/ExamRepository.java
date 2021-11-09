package com.theo.repositories;


import com.theo.databaselaborator3facultate.Exam;
import com.theo.entities.ExamEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Named
@ApplicationScoped
public class ExamRepository extends DataRepository<Exam, String>{

    public ExamRepository() {

    }

    @Inject
    public ExamRepository(EntityManager em) {
        this.examManagerPU = em;
        ExamEntity exam = em.find(ExamEntity.class, 2);
        System.out.println("Here" + exam.getName());
    }

    @Override
    public Exam getById(String s) {
        return null;
    }

    @Override
    public void updateEntities(List<Exam> entities) {
        for (Exam exam : entities){
            save(exam);
        }
    }

    @Override
    public List<Exam> getAll() {
        Query query = examManagerPU.createQuery("SELECT e FROM ExamEntity e");
        ((Collection<ExamEntity>) query.getResultList()).stream().map(ExamEntity::getName).forEach(System.out::println);
        return new ArrayList<>();
    }

    @Override
    public void save(Exam exam) {
        examManagerPU.persist(exam);
    }
}
