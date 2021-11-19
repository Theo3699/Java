package com.theo.beans;

import com.theo.databaselaborator3facultate.StatefulBeanRemote;
import com.theo.entities.ExamEntity;
import com.theo.repositories.ExamRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
@LocalBean
public class AssignmentStatefulBean implements StatefulBeanRemote {

    @Inject
    private ExamRepository examRepo;

    @Override
    public void test() {
        ExamEntity exam = examRepo.getBySpecificName("acso");
        System.out.println("AICIAAAAA " + exam.getName());
    }

}
