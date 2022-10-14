package jm.task.core.jdbc;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;
import jm.task.core.jdbc.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

//        UserService.createTable(); //Создать таблицу
//
//        UserService.saveUser(); //Добавить юзера

        UserService.getUserById(); //Выбрать юзера по id

        UserService.removeUserById(); //Удалить юзера по id


//        System.out.println("Выбери id юзера:");
//        Scanner scannerId = new Scanner(System.in);
//        id = scannerId.nextInt();
//        System.out.println(id);
//
//
//        User user = Dao.getUserById(id);
//        System.out.println(user);


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//        System.out.println("Выбери name юзера:");
//        Scanner scannerName = new Scanner(System.in);
//        String name = scannerName.next();
//
//        List<User> arrayUsersName = Dao.getUserByName(name);
//        System.out.println("Количество юзеров: " + arrayUsersName.size());
//        for (int i = 0; i < arrayUsersName.size(); i++) {
//            System.out.println(arrayUsersName.get(i));
//        }

// System.out.println("\nid: " + arrayUsersName.get(i).getId() + "\nname: " + arrayUsersName.get(i).getName() + "\nposition: " + arrayUsersName.get(i).getPosition() + "\ndate: " + arrayUsersName.get(i).getDate());

// //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//        System.out.println("Выбери position юзера:");
//        Scanner scannerPosition = new Scanner(System.in);
//        String position = scannerPosition.next();
//
//
//        List<User> arrayUsersPosition = Dao.getUserByPosition(position);
//        System.out.println("Количество юзеров: " + arrayUsersPosition.size());
//        for (int i = 0; i < arrayUsersPosition.size(); i++) {
//            System.out.println(arrayUsersPosition.get(i));
//        }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//        System.out.println("Выбери date юзера:");
//        Scanner scannerDate = new Scanner(System.in);
//        String date = scannerDate.next();
//
//        List<User> arrayUsersDate = Dao.getUserByDate(date);
//        System.out.println("Количество юзеров: " + arrayUsersDate.size());
//        for (int i = 0; i < arrayUsersDate.size(); i++) {
//        System.out.println(arrayUsersDate.get(i));
//            System.out.println("\nid: " + arrayUsersDate.get(i).getId() + "\nname: " + arrayUsersDate.get(i).getName() + "\nposition: " + arrayUsersDate.get(i).getPosition() + "\ndate: " + arrayUsersDate.get(i).getDate());
//        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        System.exit(0);
    }
}