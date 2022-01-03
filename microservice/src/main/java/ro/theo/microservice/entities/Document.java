package ro.theo.microservice.entities;

import javax.persistence.*;

@Table(name = "documents", indexes = {
        @Index(name = "table_name_author_uindex", columnList = "author", unique = true)
})
@NamedQueries({
        @NamedQuery(name = "Document.getAll",
                query = "select d from Document d order by d.name"),
        @NamedQuery(name = "Document.find",
                query = "select d from Document d where d.author = :name")
})
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "content", length = 1000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}