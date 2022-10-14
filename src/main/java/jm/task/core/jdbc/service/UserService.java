package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    public static void createTable() {
        Dao.createTable();
        System.exit(0);
    }

     static void saveUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя:");
        String name = scanner.nextLine();
        System.out.println("Дата заезда:");
        String position = scanner.nextLine();
        System.out.println("Дата:");
        String date = scanner.nextLine();

        try {
            Dao.saveUser(name, position, date);
        } catch (SQLException e) {
            System.err.println("<<<UserService>>> <<<Dao.saveUser>>>: " + e);
        }
        System.exit(0);
    }

    public static void getUserById() throws SQLException {
        System.out.println("Выбери id выбранного юзера:");
        Scanner scannerRemove = new Scanner(System.in);
        scannerRemove = new Scanner(System.in);
        int id = scannerRemove.nextInt();

        User user = Dao.getUserById(id);
        System.out.println(user);

        System.exit(0);
    }

    public static void removeUserById() throws SQLException {
        System.out.println("Выбери id юзера для удаления:");
        Scanner scannerRemove = new Scanner(System.in);
        scannerRemove = new Scanner(System.in);
        int id = scannerRemove.nextInt();

        Dao.removeUserById(id);
        User user = Dao.getUserById(id);
        if (user.getId() == 0) {
            System.out.println("Юзер id: " + id + " удалён");
        }
        System.exit(0);
    }
}
