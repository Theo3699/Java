package com.theo.beans;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AssignmentBeanManager {

    @EJB
    private AssignmentStatefulBean statefulBean;

    public AssignmentBeanManager() {
    }

    public void assignProjector(){
        statefulBean.assignProjector();
    }

    public void assignRoom() {
        statefulBean.assignRoom();
    }
}
