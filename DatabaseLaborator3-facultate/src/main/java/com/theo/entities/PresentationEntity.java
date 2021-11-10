package com.theo.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class PresentationEntity extends ExamEntity{
    @Column(name = "allocatedtime")
    private String allocatedTime;
    @Column(name = "presentation_name")
    private String presentationName;

    public void setAllocatedTime(String allocatedTime) {
        this.allocatedTime = allocatedTime;
    }

    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    public String getAllocatedTime() {
        return allocatedTime;
    }

    public String getPresentationName() {
        return presentationName;
    }
}
