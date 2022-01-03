package ro.theo.microservice.beans;

import com.sun.istack.NotNull;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class DocumentBean {
    private Integer id;
    @NotNull
    @Size(max=100)
    private String name;
    @NotNull
    @Size(max=100)
    private String author;
    @NotNull
    @Size(min=20, max=1000)
    private String content;

    public DocumentBean() {
    }

    public DocumentBean(String name, String author, String content) {
        this.name = name;
        this.author = author;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentBean(Integer id, String name, String author, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(@Size(min = 20) String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(@Size(min = 20) String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(@Size(min = 20) String content) {
        this.content = content;
    }
}
