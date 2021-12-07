package ro.theo.lab7.repositories;

import ro.theo.lab7.beans.UserBean;

public interface RepositoryInterface {
    int countAdmins();
    void save(UserBean user);
}
