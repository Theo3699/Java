package ro.theo.lab7.beans;

import ro.theo.lab7.DAOs.LoginDAO;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Login implements Serializable {
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

    //validate login
    public String validateUsernamePassword() throws SQLException, IOException {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            if (LoginDAO.isAdmin(user, pwd)) {
                System.out.println("forwarding to admin page");
                return "admin";
            }
            else{
                System.out.println("forwarding to user page");
                return "user";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "index";
        }
    }

}