package com.theo.databaselaborator3facultate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Database implements Serializable {
    Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "Th30d0r12";

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("Database error :" + e.getMessage());
        }

        return connection;
    }

    public boolean submit(Exam exam){
        String sql = "INSERT INTO exams (name, startingtime, duration) VALUES(?, ?, ?)";
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, exam.getName());
            pstmt.setString(2, exam.getStartingTime());
            pstmt.setString(3, exam.getMinutes());
            pstmt.executeUpdate();
            System.out.println("Added exam");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean submit(Student student){
        String sql = "INSERT INTO students (name, examname) VALUES(?, ?)";
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getExam());
            pstmt.executeUpdate();
            System.out.println("Student added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Exam> getExams(){
        String sql = "SELECT * FROM exams";
        List<Exam> queriedExams = new ArrayList<>();
        try{
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String examName = resultSet.getString("name");
                String examStartingTime = resultSet.getString("startingtime");
                String examDuration = resultSet.getString("duration");
                queriedExams.add(new Exam(examName, examStartingTime, examDuration));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return queriedExams;
    }

    public List<Student> getStudents(){
        String sql = "SELECT * FROM students";
        List<Student> queriedStudents = new ArrayList<>();
        try{
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String studentName = resultSet.getString("name");
                String studentExamName = resultSet.getString("examname");
                queriedStudents.add(new Student(studentName, studentExamName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return queriedStudents;
    }

}