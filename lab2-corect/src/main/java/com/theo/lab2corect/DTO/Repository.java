package com.theo.lab2corect.DTO;

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
}
