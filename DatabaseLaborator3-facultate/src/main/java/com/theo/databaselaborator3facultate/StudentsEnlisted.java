package com.theo.databaselaborator3facultate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.*;

@ManagedBean(name="studentsEnlisted")
@ViewScoped
public class StudentsEnlisted implements Serializable {
    private String currentExam;
    private int countStudents;

    public int getCountStudents() {
        Connection connection;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "Th30d0r12";
        String sql = "SELECT COUNT(*) FROM students WHERE " + currentExam + " = upper(students.examname);";
        int counter = 0;
        try{
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);
            counter = resultSet.getInt(1);
            System.out.println(counter);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return counter;
    }

    public void setCountStudents(int countStudents) {
        this.countStudents = countStudents;
    }

    public StudentsEnlisted() {
    }

    public void setCurrentExam(String currentExam) {
        this.currentExam = currentExam;
    }

    public String getCurrentExam() {
        return currentExam;
    }

    public void getNumberOfStudents(){
        Connection connection;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "Th30d0r12";
        String sql = "SELECT COUNT(*) AS rowcount FROM students WHERE '" + currentExam + "' = lower(students.examname)";
        int counter = 0;
        try{
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                counter = resultSet.getInt("rowcount");
            }
            System.out.println("Students enlisted for " + currentExam + ": " + counter);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
