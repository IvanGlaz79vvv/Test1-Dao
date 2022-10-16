package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class UserService {
    public static void createTable() {
        Dao.createTable();
        System.exit(0);
    }

    public static void saveUser() throws IOException, SQLException {
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
        int userId = Dao.getLastdId();

        User user = Dao.getUserById(userId);
        System.out.println("Вы создали юзера:\n" + user);
        System.exit(0);
    }

    public static void getUserById() throws SQLException {

        System.out.println("Выбери id выбранного юзера:");

        Scanner scannerRemove = new Scanner(System.in);
        scannerRemove = new Scanner(System.in);
        int id = scannerRemove.nextInt();
        Instant start = Instant.now();
        User user = Dao.getUserById(id);
        System.out.println(user);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);

        System.exit(0);
    }

    public static void getUserByName() throws SQLException {
        System.out.println("Выбери name юзера:");
        Scanner scannerName = new Scanner(System.in);
        String name = scannerName.next();

        List<User> arrayUsersName = Dao.getUserByName(name);
        System.out.println("Количество юзеров: " + arrayUsersName.size());
        for (User print : arrayUsersName)
            System.out.println(print);
//                int i = 0; i < arrayUsersName.size(); i++) {
//            System.out.println(arrayUsersName.get(i));
        System.exit(0);
    }

    public static void getUserByPosition() throws SQLException {
        System.out.println("Выбери position юзера:");
        Scanner scannerPosition = new Scanner(System.in);
        String position = scannerPosition.next();

        List<User> arrayUsersPosition = Dao.getUserByPosition(position);
        System.out.println("Количество юзеров: " + arrayUsersPosition.size());
        for (int i = 0; i < arrayUsersPosition.size(); i++) {
            System.out.println(arrayUsersPosition.get(i));

            System.exit(0);
        }
    }

    public static void getUserByDate() throws SQLException {
        System.out.println("Выбери date юзера:");
        Scanner scannerDate = new Scanner(System.in);
        String date = scannerDate.next();

        List<User> arrayUsersDate = Dao.getUserByDate(date);
        System.out.println("Количество юзеров: " + arrayUsersDate.size());
        for (int i = 0; i < arrayUsersDate.size(); i++) {
            System.out.println(arrayUsersDate.get(i));
        }
        System.exit(0);
    }

    public static void removeUserById() throws SQLException {
        System.out.println("Выбери id юзера для удаления:");
        Scanner scannerRemove = new Scanner(System.in);
        scannerRemove = new Scanner(System.in);
        int id = scannerRemove.nextInt();

        Dao.removeUserById(id);

        System.exit(0);
    }
}

