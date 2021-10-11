package com.theo.lab2corect.DTOs;

import java.util.ArrayList;

public class Repository {
    ArrayList<Record> records;

    public Repository() {
        this.records = new ArrayList<>();
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record){
        this.records.add(record);
    }

    @Override
    public String toString() {
        return "<table style=width:100%>" +
                "  <tr>" +
                "    <th>Category</th>" +
                "    <th>Key</th>" +
                "    <th>Value</th>" +
                "  </tr>" +
               records +
                "</table>";
    }
}
