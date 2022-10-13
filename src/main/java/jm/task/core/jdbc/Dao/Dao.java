package jm.task.core.jdbc.Dao;


import jm.task.core.jdbc.Model.User;
import jm.task.core.jdbc.Utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {

    private static User user = new User();

    private static final String URL = "jdbc:mysql://localhost:3306/newbd";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    private final String newtable = "newtable";
    private static final Connection conn = Util.getConnection();
    private final String CREATETABLE = "CREATE TABLE IF NOT EXISTS newtable"
            + "(id int PRIMARY KEY AUTO_INCREMENT, "
            + "name varchar(100),"
            + "position varchar(100), "
            + "date varchar(100))";
    private final String SAVEUSER = "INSERT INTO newtable (name, position, date) VALUES (?, ?, ?)";
    private final String DELETE = "DELETE FROM newtable WHERE id = ?";
    private static final String SELECTid = "SELECT * FROM newtable WHERE id = ?/* LIMIT 1*/";
    private static final String SELECTname = "SELECT * FROM newtable WHERE name = ? /*LIMIT 1*/";
    private static final String SELECTposition = "SELECT * FROM newtable WHERE position = ?/* LIMIT 1*/";
    private static final String SELECTdate = "SELECT * FROM newtable WHERE date = ?/* LIMIT 1*/";
//    private static User user = null;


    public void createTable() {
        try (Statement statement = conn.createStatement()) {
            conn.setAutoCommit(false);
            statement.executeUpdate(CREATETABLE);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("^^^^^Сработал createUsersTable() -> rollback()^^^^^\n");
            } catch (SQLException ex) {
                System.out.println("\n-----Начало ошибки rollback() createUsersTable()-----");
                ex.printStackTrace();
                System.out.println("^^^^^Конец ошибки rollback() createUsersTable()^^^^^");
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("-----Начало ошибки setAutoCommit(true) createUsersTable()-----");
                e.printStackTrace();
                System.out.println("^^^^^Ошибка setAutoCommit(true) createUsersTable()^^^^^");
            }
        }
    }

    public void saveUser(String name, String position, String date) throws SQLException {
        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(SAVEUSER)) {
            pstmt.setString(1, name);
            pstmt.setString(2, position);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.err.println("<<<saveUser>>> " + e);
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static User getUserById(int id) throws SQLException {

        conn.setAutoCommit(false);
        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECTid)) {  /*"SELECT * FROM newtable WHERE id = ? LIMIT 1"*/

//            PreparedStatement preparedStatement = conn.prepareStatement(SELECTid);
            preparedStatement.setInt(1, id);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date

                User user = new User(userId, name, position, date);
                System.out.println(user.getName());
                conn.commit();
            }
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return user;
    }

    public static List<User> getUserByName(String name) throws SQLException {
        List<User> arrayUsersByName = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECTname)) {  /*"SELECT * FROM newtable WHERE name = ? LIMIT 1"*/
            conn.setAutoCommit(false);

            preparedStatement.setString(1, name);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date
                user = new User(userId, name, position, date); //собираем юзера

                arrayUsersByName.add(user);
            }
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return arrayUsersByName;
    }

    public static List<User> getUserByPosition(String position) throws SQLException {
        List<User> arrayUsersByPosition = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECTposition)) {
            conn.setAutoCommit(false);

            preparedStatement.setString(1, position);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date
                user = new User(userId, name, position, date); //собираем юзера

                arrayUsersByPosition.add(user);
            }
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return arrayUsersByPosition;
    }

    public static List<User> getUserByDate(String date) throws SQLException {
        List<User> arrayUsersByDate = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECTdate)) {  /*"SELECT * FROM newtable WHERE date = ? LIMIT 1"*/
            conn.setAutoCommit(false);

            preparedStatement.setString(1, date);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                date = resultSet.getString(4); // получили date

                user = new User(userId, name, position, date);
                arrayUsersByDate.add(user);
            }
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return arrayUsersByDate;
    }

    public void removeUserById(int id) throws SQLException {
        conn.setAutoCommit(false);
        try (PreparedStatement preparedStatement = conn.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.err.println("<<<removeUserById>>> Запущен rollback()" + e);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}