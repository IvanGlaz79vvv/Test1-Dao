package jm.task.core.jdbc.Dao;

import jm.task.core.jdbc.Model.User;
import jm.task.core.jdbc.Utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoHibernate {

    private static final String URL = "jdbc:mysql://localhost:3306/newbd";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    private final String Tadzhiki = "Tadzhiki";
    private static final Connection conn = Util.getConnection();
    private final String CREATETABLE = "CREATE TABLE IF NOT EXISTS Tadzhiki"
            + "(id int PRIMARY KEY AUTO_INCREMENT, "
            + "name varchar(100),"
            + "position varchar(100), "
            + "date varchar(100))";
    private final String SAVEUSER = "INSERT INTO Tadzhiki (name, position, date) VALUES (?, ?, ?)";
    private final String DELETE = "DELETE FROM newtable WHERE id = ?";
    private static final String SELECTid = "SELECT * FROM newtable WHERE id = ? LIMIT 1";//mysql
    private static final String SELECTname = "SELECT * FROM newtable WHERE name = ? LIMIT 1";//mysql
    private static final String SELECTposition = "SELECT * FROM newtable WHERE position = ? LIMIT 1";//mysql
    private static final String SELECTdate = "SELECT * FROM newtable WHERE date = ? LIMIT 1";//mysql
    private static User user = null;


    public static User getUserById(int id) throws SQLException {

        try (Connection conn = Util.getConnection()) {  /*"SELECT * FROM newtable WHERE id = ? LIMIT 1"*/

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SELECTid);
            preparedStatement.setInt(1, id);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date

                user = new User(userId, name, position, date);
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


    public static User getUserByName(String name) throws SQLException {

        try (Connection conn = Util.getConnection()) {  /*"SELECT * FROM newtable WHERE name = ? LIMIT 1"*/

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SELECTname);
            preparedStatement.setString(1, name);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date

                user = new User(userId, name, position, date);
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


    public static User getUserByPosition(String position) throws SQLException {

        List<User> arrayUsers = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECTposition)) {
            conn.setAutoCommit(false);

            ; /*"SELECT * FROM newtable WHERE name = ? LIMIT 1"*/
            preparedStatement.setString(1, position);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date

                user = new User(userId, name, position, date); //собираем юзера
                arrayUsers.add(user);
                System.out.println("user = " + user);
            }
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return user;
    }


    public static User getUserByDate(String date) throws SQLException {

        try (Connection conn = Util.getConnection()) {  /*"SELECT * FROM newtable WHERE date = ? LIMIT 1"*/

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement(SELECTdate);
            preparedStatement.setString(1, date);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                date = resultSet.getString(4); // получили date

                user = new User(userId, name, position, date);
            }
            conn.commit();
        } catch (SQLException e) {
            System.err.println("<<<getUserById>>> " + e);
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return user;
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
