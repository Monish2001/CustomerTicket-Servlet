package com.operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "hellosql@123";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL,
                dbUsername,
                dbPassword);
        return con;
    }
}
