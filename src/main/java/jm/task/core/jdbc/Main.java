package jm.task.core.jdbc;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dao dao = new Dao();
        dao.createTable();

        Scanner scanner = new Scanner(System.in);
//            dao.saveUser("Иван", "17", "1979");
//        dao.removeUserById(2);
        dao.selectUserById();

//        System.out.println("Имя:");
//        String name = scanner.nextLine();
//        System.out.println("Дата заезда:");
//        String position = scanner.nextLine();
//        System.out.println("Дата:");
//        String date = scanner.nextLine();
//        scanner.close();

//        try{
//            System.out.println(name);
//            System.out.println(position);
//            System.out.println(date);
//        }catch (Exception e) {
//            System.err.println("<<<Ошибка вывода в main>>> " + e);
//        }

//        Instant start = Instant.now();


//        Instant finish = Instant.now();
//        long elapsed = Duration.between(start, finish).toMillis();
//        System.out.println("Финиш.\nПрошло времени, мс: " + elapsed);
//        System.out.println("Юзеры добавлены");

//        System.out.println("Удалить Юзера по Id, введите id:");
//        int id = scanner.nextInt();
//        dao.removeUserById(id);


//        System.out.println("Выбери id юзера:");
//        id = scanner.nextInt();

//        List<User> getUser = dao.selectUserById();
//        for (User printuser : getUser) {
//            if (id == printuser.getId()) {
//                System.out.println(printuser.getId() + "\t" + printuser.getName() + "\t" + printuser.getDate());
//            }
//        }
//        for(User printUser : getUser) {
//            System.out.println(printUser.toString());
//        }

        System.exit(0);
    }
}