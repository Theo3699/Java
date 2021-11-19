package com.theo.beans;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class SingletonManager {

    @EJB
    private SingletonCurrentAssignments singleton;

    public void startup(){
        singleton.init();
    }
}
