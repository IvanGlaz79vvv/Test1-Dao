package jm.task.core.jdbc;

import jm.task.core.jdbc.Dao.Dao;
import jm.task.core.jdbc.Model.User;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dao dao = new Dao();
//        dao.createTable();

/**      try {
 Scanner scanner = new Scanner(System.in);
 System.out.println("Имя:");
 String name = scanner.nextLine();
 System.out.println("Дата заезда:");
 String position = scanner.nextLine();
 System.out.println("Дата:");
 String date = scanner.nextLine();
 scanner.close();

 dao.saveUser(name, position, date);

 } catch (Exception e) {
 System.err.println("<<<Ошибка ввода-вывода в main>>> " + e);
 }

 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 System.out.println("Выбери id юзера для удаления:");
 Scanner scannerRemove = new Scanner(System.in);
 scannerRemove = new Scanner(System.in);
 int id = scannerRemove.nextInt();
 scannerRemove.close();

 dao.removeUserById(id);

 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

 Instant start = Instant.now();
 Instant finish = Instant.now();
 long elapsed = Duration.between(start, finish).toMillis();
 System.out.println("Финиш.\nПрошло времени, мс: " + elapsed);
 System.out.println("Юзеры добавлены");

 System.out.println("Удалить Юзера по Id, введите id:");
 int id = scanner.nextInt();
 dao.removeUserById(id);
 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

 System.out.println("Выбери id юзера:");
 Scanner scannerId = new Scanner(System.in);
 scannerId = new Scanner(System.in);
 int id = scannerId.nextInt();
 scannerId.close();

 User user = Dao.getUserById(id);
 System.out.println("id: " + user.getId() + "\nname: " + user.getName() + "\nposition: " + user.getPosition() + "\ndate: " + user.getDate());
 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

 System.out.println("Выбери name юзера:");
 Scanner scannerName = new Scanner(System.in);
 String name = scannerName.next();
 scannerName.close();

 List<User> arrayUsersName = Dao.getUserByName(name);
 System.out.println("Количество юзеров: " + arrayUsersName.size());
 for (int i = 0; i < arrayUsersName.size(); i++) {
 System.out.println("\nid: " + arrayUsersName.get(i).getId() + "\nname: " + arrayUsersName.get(i).getName() + "\nposition: " + arrayUsersName.get(i).getPosition() + "\ndate: " + arrayUsersName.get(i).getDate());
 }
 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

 System.out.println("Выбери position юзера:");
 Scanner scannerPosition = new Scanner(System.in);
 String position = scannerPosition.next();
 scannerPosition.close();

 List<User> arrayUsersPosition = Dao.getUserByPosition(position);
 System.out.println("Количество юзеров: " + arrayUsersPosition.size());
 for (int i = 0; i < arrayUsersPosition.size(); i++) {
 System.out.println("\nid: " + arrayUsersPosition.get(i).getId() + "\nname: " + arrayUsersPosition.get(i).getName() + "\nposition: " + arrayUsersPosition.get(i).getPosition() + "\ndate: " + arrayUsersPosition.get(i).getDate());
 }
 */
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        System.out.println("Выбери date юзера:");
        Scanner scannerDate = new Scanner(System.in);
        String date = scannerDate.next();
        scannerDate.close();

        List<User> arrayUsersDate = Dao.getUserByDate(date);
        System.out.println("Количество юзеров: " + arrayUsersDate.size());
        for (int i = 0; i < arrayUsersDate.size(); i++) {
            System.out.println("\nid: " + arrayUsersDate.get(i).getId() + "\nname: " + arrayUsersDate.get(i).getName() + "\nposition: " + arrayUsersDate.get(i).getPosition() + "\ndate: " + arrayUsersDate.get(i).getDate());
        }
        System.exit(0);
    }
}