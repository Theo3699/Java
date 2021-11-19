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

    @Inject
    private ResourcesBean resourcesBean;

    @Override
    public void assignProjector() {
        if (resourcesBean.getAvailableProjectors() > 0) {
            ExamEntity exam = examRepo.getBySpecificName("acso");
            if (!exam.getResources().isEmpty()) {
                exam.setResources(exam.getResources() + ", projector");
            } else {
                exam.setResources("projector");
            }
        }
    }

    @Override
    public void assignRoom() {
        if (resourcesBean.getAvailableRooms() > 0) {
            ExamEntity exam = examRepo.getBySpecificName("acso");
            if (!exam.getResources().isEmpty()) {
                exam.setResources(exam.getResources() + ", room");
            } else {
                exam.setResources("room");
            }
        }
    }
}
