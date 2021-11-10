package com.theo.entities;

public abstract class AbstractEntity<ID> {
    private ID id;

    public AbstractEntity() {
    }

    public AbstractEntity(ID id) {
        this.id = id;
    }

    public Integer getId() {
        return (Integer) id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
