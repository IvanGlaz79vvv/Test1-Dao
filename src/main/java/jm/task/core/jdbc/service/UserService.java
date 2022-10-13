package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Dao.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    public static void createTable() {
        Dao.createTable();
    }

    public static void saveUser(String name, String position, String date) throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Имя:");
            name = scanner.nextLine();
            System.out.println("Дата заезда:");
            position = scanner.nextLine();
            System.out.println("Дата:");
            date = scanner.nextLine();
            Dao.saveUser(name, position, date);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
