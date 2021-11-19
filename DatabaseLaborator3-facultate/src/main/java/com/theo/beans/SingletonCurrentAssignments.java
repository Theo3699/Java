package com.theo.beans;

import com.theo.repositories.ExamRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;

@Singleton
public class SingletonCurrentAssignments implements Serializable {
    HashMap<String, String> examToResource = new HashMap<String, String>();

    @Inject
    private ExamRepository examRepo;

    @PostConstruct
    public void init() {
        examToResource = examRepo.getExamAndResources();
        System.out.println("Exam and resources:\n" + examToResource);
    }
}
