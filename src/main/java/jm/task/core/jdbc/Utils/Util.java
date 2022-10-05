package jm.task.core.jdbc.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/newbd";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения");
            e.printStackTrace();
        }
        return connection;
    }
}
