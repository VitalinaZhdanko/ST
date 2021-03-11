package com.zhdanko.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "secret00";

    public static Connection GetConnection() {
        if (connection == null) {
            tryToConnectDatabase();
        }
        return connection;
    }

    private static void tryToConnectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
