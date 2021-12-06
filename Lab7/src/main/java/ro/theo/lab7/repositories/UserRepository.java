package ro.theo.lab7.repositories;

import ro.theo.lab7.beans.UserBean;
import ro.theo.lab7.config.MyInterceptorBinding;
import ro.theo.lab7.entities.User;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;

@ManagedBean
@Transactional(rollbackOn = {SQLException.class})
@MyInterceptorBinding
public class UserRepository {

    @Inject
    protected EntityManager userManagerPU;

    public UserRepository() {

    }

    public int countAdmins(){
        Query query = userManagerPU.createNamedQuery("User.countAdmins");
        int resourceResults = ((Number)query.getSingleResult()).intValue();
        return resourceResults;
    }

    public void save(UserBean user){
        userManagerPU.getTransaction().begin();
        User userEntiy = new User();
        userEntiy.setAdmin(user.getAdmin());
        userEntiy.setUsername(user.getUsername());
        userEntiy.setPassword(user.getPassword());
        userManagerPU.persist(userEntiy);
        userManagerPU.getTransaction().commit();
    }
}
