package com.theo.repositories;

import com.theo.entities.ExamEntity;
import com.theo.entities.ResourceEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ResourcesRepository extends DataRepository<ResourceEntity, Integer> {

    public ResourcesRepository() {
    }

    @Inject
    public ResourcesRepository(EntityManager em) {
        this.examManagerPU = em;
    }

    @Override
    public ResourceEntity getById(Integer integer) {
        return null;
    }

    @Override
    public void updateEntities(List<ResourceEntity> entities) {
        for (ResourceEntity resource : entities) {
            save(resource);
        }
    }

    @Override
    public List<ResourceEntity> getAll() {
        Query query = examManagerPU.createNamedQuery("Resource.findAll");
        List<ResourceEntity> resources = ((Collection<ResourceEntity>) query.getResultList()).stream().collect(Collectors.toList());
        return resources;
    }

    @Override
    public void save(ResourceEntity resourceEntity) {
        examManagerPU.getTransaction().begin();
        examManagerPU.persist(resourceEntity);
        examManagerPU.getTransaction().commit();
        System.out.println("Resources database updated!");
    }

    @Override
    public void getByName() {
        Query query = examManagerPU.createNamedQuery("Resource.available");
//        query.setParameter("name", "java");
        Collection resourceResults = query.getResultList();
        for (Object resource : resourceResults) {
            System.out.println("GetByName() from Resources: " + ((ResourceEntity) resource).getResource());
        }
    }

    public int getAvailableProjectors() {
        Query query = examManagerPU.createNamedQuery("Projector.available");
        int resourceResults = ((Number)query.getSingleResult()).intValue();
        return resourceResults;
    }

    public int getAvailableRooms() {
        Query query = examManagerPU.createNamedQuery("Room.available");
        int resourceResults = ((Number)query.getSingleResult()).intValue();
        return resourceResults;
    }

}
