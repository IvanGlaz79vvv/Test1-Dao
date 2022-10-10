package jm.task.core.jdbc.Dao;


import jm.task.core.jdbc.Model.User;
import jm.task.core.jdbc.Utils.Util;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dao {
    //    private final String SAVETableIvan = "INSERT INTO TableIvan (Name, Last_Name, age) VALUES (?, ?, ?)";
    //    String SELECT = "Select name From TableIvan where id = ?";

    Util connect = new Util();

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
    private final String DELETE = "DELETE FROM Tadzhiki WHERE id = ?";
    private final String SELECT = "SELECT * FROM Tadzhiki";//mysql


    public static User getUser(int id) {
        String sql = "SELECT * FROM newtable WHERE id = ? LIMIT 1";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql) {
            preparedStatement.setInt(1, id);  // так мы подставляем вместо знака вопроса нужный id
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt(1); // получили id пользователя
                String name = resultSet.getString(2); // получили имя
                String position = resultSet.getString(3); // получили поле position
                String date = resultSet.getString(4); // получили date

                return new User(userId, name, position, date); // собираем объект User из полученных данных и передаем его
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }
}




//     public void createTable() {
//     try (Connection conn = Util.getConnection()) {
//     Statement stmt = conn.createStatement();
//     stmt.execute(CREATETABLE);
//     } catch (SQLException e) {
//     System.err.println("<<<createEmployeesTable>>> " + e);
//     }
//     }
//     <p>
//     <p>
//     public void saveUser(String name, String position, String date) throws SQLException {
//     try (Connection conn = Util.getConnection()) {
//     conn.setAutoCommit(false);
//     <p>
//     try (PreparedStatement pstmt = conn.prepareStatement(SAVEUSER)) {
//     pstmt.setString(1, name);
//     pstmt.setString(2, position);
//     pstmt.setString(3, date);
//     pstmt.executeUpdate();
//     conn.commit();
//     } catch (SQLException e) {
//     conn.rollback();
//     System.err.println("<<<saveUser>>> " + e);
//     } finally {
//     conn.setAutoCommit(true);
//     }
//     }
//     }
//     <p>
//     public void removeUserById(int id) throws SQLException {
//     try (Connection conn = Util.getConnection()) {
//     conn.setAutoCommit(false);
//     try (PreparedStatement pstm = conn.prepareStatement(DELETE)) {
//     pstm.setInt(1, id);
//     pstm.executeUpdate();
//     } catch (SQLException e) {
//     conn.rollback();
//     System.err.println("<<<removeUserById>>> <<<rollback>>> " + e);
//     }
//     conn.commit();
//     } catch (SQLException e) {
//     conn.rollback();
//     } finally {
//     conn.setAutoCommit(true);
//     System.out.println("Юзер удалён");
//     }
//     }



    //    public List<User> selectUserById(int id) throws SQLException {
//    static List<User> tableArray = new ArrayList<>();
//    public static void selectUserById(int id) {
//        try (Connection conn = Util.getConnection()) {
//
//            PreparedStatement prst = conn.prepareStatement("SELECT * FROM newtable WHERE id  = 3");
//            ResultSet resultSet - new User();
//            User user = prst;
//            prst.setInt(1, id);
//
//            tableArray.add(user)
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//            User user = new User(
//                    user = rs.getString("name"),
//                    rs.getString("position"),
//                    rs.getString("date")
//                    );
//            user.setId(rs.getInt("id"));

//            while (rs.next()) {
//                id = rs.getInt("id");
//                String name = rs.getString("name");
//                String position = rs.getString("position");
//                String date = rs.getString("date");
//            }


//                    listTadzhiki.add(user);
           /* conn.commit();

        } catch (SQLException e) {
//            conn.rollback();
            System.err.println("<<<selectUserById>>> <<<rollback>>> " + e);
        } finally {
            conn.setAutoCommit(true);*/


//        for (User printuser : listTadzhiki) {
//            System.out.println(printuser);
//        }

