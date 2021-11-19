package com.theo.entities;

import javax.persistence.*;

@Table(name = "exams")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "exam_type",
                    discriminatorType = DiscriminatorType.INTEGER)
@NamedQueries({
        @NamedQuery(name = "Exam.findAll",
        query = "select e from ExamEntity e order by e.name"),
        @NamedQuery(name = "Exam.findByName",
        query = "select e from ExamEntity e where e.name = :name"),
        @NamedQuery(name = "Exam.andResources",
        query = "select e from ExamEntity e where e.resources is not null")
})
public class ExamEntity extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "startingtime", nullable = false, length = 40)
    private String startingtime;

    @Column(name = "duration", nullable = false, length = 40)
    private String duration;

    @Column(name = "resources", length = 100)
    private String resources;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(String startingtime) {
        this.startingtime = startingtime;
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

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResources() {
        return resources;
    }
}