package com.theo.lab2corect.DTO;

public class Record {
    private String category;
    private String key;
    private String value;

    public Record(String category, String key, String value) {
        this.category = category;
        this.key = key;
        this.value = value;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Record{" +
                "category='" + category + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
