package com.theo.databaselaborator3facultate;

import javax.ejb.Remote;

@Remote
public interface StatefulBeanRemote {
    public void assignProjector();
    public void assignRoom();
}
