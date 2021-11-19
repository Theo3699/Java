package com.theo.beans;

import com.theo.config.JPAConfig;
import com.theo.entities.ExamEntity;
import com.theo.entities.ResourceEntity;
import com.theo.repositories.ExamRepository;
import com.theo.repositories.ResourcesRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name="resourcesBean")
@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ResourcesBean {

    @EJB
    private ResourcesRepository resourcesRepo;

    @PostConstruct
    public void init() {
        JPAConfig jpaConfig = new JPAConfig();
        resourcesRepo = new ResourcesRepository(jpaConfig.createEM());
        System.out.println("ResourcesBean: init'ed");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ResourcesBean: destroyed");
    }

    public void getAll() {
        List<ResourceEntity> resources = resourcesRepo.getAll();
        System.out.println("Printing all resources");
        for (ResourceEntity resource : resources) {
            System.out.println(resource.getResource());
        }
    }

    public void insertResource() {
        ResourceEntity resource = new ResourceEntity();
        resource.setResource("room");
        resource.setAvailable(true);
        resourcesRepo.save(resource);
    }

    public void getByName() {
        resourcesRepo.getByName();
    }

    public void getAvailableProjectors() {
        System.out.println("Available projectors: " + resourcesRepo.getAvailableProjectors());
    }

    public void getAvailableRooms() {
        System.out.println("Available rooms: " + resourcesRepo.getAvailableRooms());
    }
}
