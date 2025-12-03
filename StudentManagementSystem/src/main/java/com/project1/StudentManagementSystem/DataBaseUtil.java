package com.project1.StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil
{
    // Edit these values for your local environment
    private static final String URL = "jdbc:mysql://localhost:3306/smsdb?useSSL=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Adithyan@2002";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

	