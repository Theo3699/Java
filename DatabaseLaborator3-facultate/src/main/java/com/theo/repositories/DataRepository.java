package com.theo.repositories;

import com.theo.entities.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class DataRepository<T extends AbstractEntity<ID>, ID> {

    @PersistenceContext(name = "ExamManagerPU")
    protected EntityManager examManagerPU;

    protected DataRepository() {

    }

    public abstract T getById(ID id);

    public EntityManager getExamManagerPU() {
        return examManagerPU;
    }

    public void setExamManagerPU(EntityManager examManagerPU) {
        this.examManagerPU = examManagerPU;
    }

    public abstract void updateEntities(List<T> entities);

    public abstract List<T> getAll();

    public abstract void save(T t);
}
