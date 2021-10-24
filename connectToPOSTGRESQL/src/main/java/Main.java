package main.java;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static  void main(String[] args) {
        try{
            Connection connection = DataBase.getInstance().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
