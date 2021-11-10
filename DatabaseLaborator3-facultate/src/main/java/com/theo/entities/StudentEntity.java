package com.theo.entities;

import javax.persistence.*;

@Table(name = "students")
@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll",
                query = "select s from StudentEntity s order by s.name"),
        @NamedQuery(name = "Student.findByName",
                query = "select s from StudentEntity s where s.name = :name")
})
public class StudentEntity extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "examname", nullable = false, length = 40)
    private String examname;

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
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
}