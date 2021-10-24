package main.java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static DataBase instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "Th30d0r12";

    private DataBase() {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("Database error :" + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataBase getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBase();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBase();
        }
        return instance;
    }
}