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

        ;
        UserService.getUserById(); //Выбрать юзера по id

//
//        UserService.getUserByName(); //Выбрать юзера по name
//
//        UserService.getUserByDate(); //Выбрать юзера по date
//
//        UserService.removeUserById(); //Удалить юзера по id



// System.out.println("\nid: " + arrayUsersName.get(i).getId() + "\nname: " + arrayUsersName.get(i).getName() + "\nposition: " + arrayUsersName.get(i).getPosition() + "\ndate: " + arrayUsersName.get(i).getDate());

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        System.exit(0);
    }
}