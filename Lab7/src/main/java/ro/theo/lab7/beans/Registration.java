package ro.theo.lab7.beans;

import ro.theo.lab7.config.MyInterceptorBinding;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class Registration {
    private List<String> roles = Arrays.asList("Admin", "User");
    private String pwd;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void goToRegistrationPage() {
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/views/registration.xhtml");
    }

    public List<String> getRoles() {
        return roles;
    }
}
