package com.theo.beans;

import com.theo.entities.ExamEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ExamBean {
    @PersistenceContext
    private final EntityManager em;

    private List<ExamEntity> exams = new ArrayList<>();

    @Inject
    public ExamBean(EntityManager em){
        this.em = em;
        ExamEntity exam = em.find(ExamEntity.class, 2);
        exams.add(exam);
        System.out.println("Here" + exams.get(0).getName());
    }

    public EntityManager getEm() {
        return em;
    }

    public List<ExamEntity> getExams() {
        return exams;
    }
}
