package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata_test";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            System.out.println("Соединение установлено");
        } catch (SQLException e) {
            System.out.println("Соединение не установлено");
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
