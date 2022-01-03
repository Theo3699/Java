package ro.theo.lab7.beans;

import ro.theo.lab7.DAOs.LoginDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static ro.theo.lab7.config.Logger.log;

@ManagedBean
@SessionScoped
public class LoginRealm {
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

    public String login() throws SQLException, ServletException, NoSuchAlgorithmException {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            HttpServletRequest request = (HttpServletRequest)
                    externalContext.getRequest();
            byte[] bytesOfPassword = pwd.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mdPassword = md.digest(bytesOfPassword);
            pwd = mdPassword.toString();
            request.login(user, pwd);

            boolean valid = LoginDAO.validate(user, pwd);
            System.out.println(valid);
            if (valid) {
                log("Login successful with credentials user: " + user + ", password: " + pwd);
                if (LoginDAO.isAdmin(user, pwd)) {
                    System.out.println("forwarding to admin page");
                    return "admin";
                } else {
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
