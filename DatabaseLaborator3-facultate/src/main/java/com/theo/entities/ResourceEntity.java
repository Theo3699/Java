package com.theo.entities;

import javax.persistence.*;

@Table(name = "resources")
@Entity
@NamedQueries({
        @NamedQuery(name = "Projector.available",
                query = "select count(*) from ResourceEntity r where r.available = true and lower(r.resource) = 'projector'"),
        @NamedQuery(name = "Room.available",
                query = "select count(*) from ResourceEntity r where r.available = true and lower(r.resource) = 'room'"),
        @NamedQuery(name = "Resource.findAll",
                query = "select r from ResourceEntity r order by r.resource"),
        @NamedQuery(name = "Resource.available",
                query = "select r from ResourceEntity r where r.available = true order by r.resource"),
        @NamedQuery(name = "Projector.findAll",
                query = "select r from ResourceEntity r where lower(r.resource) = 'projector' order by r.resource"),
        @NamedQuery(name = "Room.findAll",
                query = "select r from ResourceEntity r where lower(r.resource) = 'room' order by r.resource")
})
public class ResourceEntity extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "resource", nullable = false, length = 100)
    private String resource;

    @Column(name = "available", nullable = false)
    private Boolean available = false;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}