package com.theo.lab3final;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.*;

@ManagedBean
@RequestScoped
public class Database {
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

    public boolean addExam(Exam exam){
        String sql = "INSERT INTO exams (name, startingtime, duration) VALUES(?, ?, ?)";
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, exam.getName());
            pstmt.setString(2, exam.getStartingTime());
            pstmt.setString(3, exam.getMinutes());
            pstmt.executeUpdate();
            System.out.println(pstmt + "\nSuccess!");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
