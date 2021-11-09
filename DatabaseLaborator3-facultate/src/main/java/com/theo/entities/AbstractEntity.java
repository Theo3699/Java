package com.theo.entities;

public class AbstractEntity<ID> {
    private ID id;

    public AbstractEntity() {
    }

    public AbstractEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
