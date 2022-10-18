package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserService {
    public static void createTable() {
        Dao.createTable();
        System.exit(0);
    }

    public static void saveUser() throws IOException, SQLException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Имя:");
        String name = bufferedReader.readLine();
        System.out.println("Дата заезда:");
        String position = bufferedReader.readLine();
        System.out.println("Дата:");
        String date = bufferedReader.readLine();

        try {
            Dao.saveUser(name, position, date);
        } catch (SQLException e) {
            System.err.println("<<<UserService>>> <<<Dao.saveUser>>>: " + e);
        }
        int userId = Dao.getLastdId();

        User user = Dao.getUserById(userId);
        System.out.println("Вы создали юзера:\n" + user);

        bufferedReader.close();
        System.exit(0);
    }

    public static void getUserById() throws SQLException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выбери id юзера:");
        int id = Integer.parseInt(bufferedReader.readLine());

        User user = Dao.getUserById(id);
        System.out.println(user);

        bufferedReader.close();
        System.exit(0);
    }

    public static void getUserByName() throws SQLException, IOException {
        System.out.println("Выбери name юзера:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();

        List<User> arrayUsersName = Dao.getUserByName(name);
        System.out.println("Количество юзеров: " + arrayUsersName.size());
        for (User print : arrayUsersName) {
            System.out.println(print);
        }
        bufferedReader.close();
        System.exit(0);
    }

    public static void getUserByPosition() throws SQLException, IOException {
        System.out.println("Выбери position юзера:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String position = bufferedReader.readLine();

        List<User> arrayUsersPosition = Dao.getUserByPosition(position);
        System.out.println("Количество юзеров: " + arrayUsersPosition.size());
        for (User print : arrayUsersPosition) {
            System.out.println(print);
        }

        bufferedReader.close();
        System.exit(0);
    }


    public static void getUserByDate() throws SQLException, IOException {
        System.out.println("Выбери date юзера:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String date = bufferedReader.readLine();

        List<User> arrayUsersDate = Dao.getUserByDate(date);
        System.out.println("Количество юзеров: " + arrayUsersDate.size());
        for (int i = 0; i < arrayUsersDate.size(); i++) {
            System.out.println(arrayUsersDate.get(i));
        }
        bufferedReader.close();
        System.exit(0);
    }

    public static void removeUserById() throws SQLException, IOException {
        System.out.println("Выбери id юзера для удаления:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scannerRemove = new Scanner(System.in);
        scannerRemove = new Scanner(System.in);
        int id = Integer.parseInt(bufferedReader.readLine());

        Dao.removeUserById(id);

        bufferedReader.close();
        System.exit(0);
    }
}

