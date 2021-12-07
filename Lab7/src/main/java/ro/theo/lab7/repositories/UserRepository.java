package ro.theo.lab7.repositories;

import ro.theo.lab7.beans.UserBean;
import ro.theo.lab7.config.MyInterceptorBinding;
import ro.theo.lab7.entities.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

@ManagedBean
@Transactional(rollbackOn = {SQLException.class})
@MyInterceptorBinding
public class UserRepository implements RepositoryInterface {

    @Inject
    protected EntityManager userManagerPU;

    public UserRepository() {

    }

    @Override
    public int countAdmins() {
        Query query = userManagerPU.createNamedQuery("User.countAdmins");
        int resourceResults = ((Number) query.getSingleResult()).intValue();
        return resourceResults;
    }

    @Override
    public void save(UserBean user) {
        userManagerPU.getTransaction().begin();
        User userEntiy = new User();
        userEntiy.setAdmin(user.getAdmin());
        userEntiy.setUsername(user.getUsername());
        userEntiy.setPassword(user.getPassword());
        userManagerPU.persist(userEntiy);
        userManagerPU.getTransaction().commit();
    }

    public void checkTimeFrame(UserBean user) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour <= 20 && hour >= 8) {
            save(user);
            System.out.println("Registration completed");
        } else {
            System.out.println("Can't register now. Try later!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("kilometres", new FacesMessage("Message 1"));
        }
    }
}
