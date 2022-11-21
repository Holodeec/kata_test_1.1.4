package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
