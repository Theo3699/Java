package ro.theo.lab7.DAOs;

import java.sql.*;

public class LoginDAO {

    public static boolean validate(String user, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usernameDB = "postgres";
        String passwordDB = "Th30d0r12";

        try {
            con = DriverManager.getConnection(url, usernameDB, passwordDB);
            ps = con.prepareStatement("Select username, password from users where username = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        }
        return false;
    }

    public static boolean isAdmin(String user, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usernameDB = "postgres";
        String passwordDB = "Th30d0r12";

        try {
            con = DriverManager.getConnection(url, usernameDB, passwordDB);
            ps = con.prepareStatement("Select admin from users where username = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boolean isAdmin = rs.getBoolean("admin");
                if (isAdmin) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        }
        return false;
    }
}