package com.theo.lab2.DTOs;

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
        return "<tr>" +
                "    <td><center>" + getCategory() + "</center></td>" +
                "    <td><center>" + getKey() + "</center></td>" +
                "    <td><center>" + getValue() + "</center></td>" +
                "  </tr>";
    }
}