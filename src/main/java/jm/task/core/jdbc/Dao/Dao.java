package jm.task.core.jdbc.Dao;


import jm.task.core.jdbc.Model.User;
import jm.task.core.jdbc.Utils.Util;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    //    private final String SAVETableIvan = "INSERT INTO TableIvan (Name, Last_Name, age) VALUES (?, ?, ?)";
    //    String SELECT = "Select name From TableIvan where id = ?";

    Util connect = new Util();

    private final String Tadzhiki = "Tadzhiki";
    private final Connection conn = Util.getConnection();
    private final String URL = "jdbc:mysql://localhost:3306/newbd";
    private final String CREATETABLE = "CREATE TABLE IF NOT EXISTS Tadzhiki"
            + "(id int PRIMARY KEY AUTO_INCREMENT, "
            + "name varchar(100),"
            + "position varchar(100), "
            + "date varchar(100))";
    private final String SAVEUSER = "INSERT INTO Tadzhiki (name, position, date) VALUES (?, ?, ?)";
    private final String DELETE = "DELETE FROM Tadzhiki WHERE id = ?";
    private final String SELECT = "SELECT * FROM Tadzhiki";//mysql


    public void createTable() {
        try (Connection conn = Util.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.execute(CREATETABLE);
        } catch (SQLException e) {
            System.err.println("<<<createEmployeesTable>>> " + e);
        }
    }

    public void saveUser(String name, String position, String date) throws SQLException {
        try (Connection conn = Util.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement(SAVEUSER)) {
                pstmt.setString(1, name);
                pstmt.setString(2, position);
                pstmt.setString(3, date);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("<<<saveUser>>> " + e);
            }
            conn.commit();
        }
        conn.setAutoCommit(true);
    }

    public void removeUserById(int id) throws SQLException {
        try (Connection conn = Util.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement pstm = conn.prepareStatement(DELETE)) {
                pstm.setInt(1, id);
                pstm.executeUpdate();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("<<<removeUserById>>> <<<rollback>>> " + e);
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        }
        conn.setAutoCommit(true);
        System.out.println("Юзер удалён");
    }

    public List<User> selectUserById() throws SQLException {
        List<User> listTadzhiki = new ArrayList<>();
        try (Connection conn = Util.getConnection()) {
            conn.setAutoCommit(false);

                try (ResultSet rst = conn.createStatement().executeQuery("SELECT * FROM Tadzhiki WHERE id = 2");) {
                    while (rst.next()) {
                        User user = new User(
                                user.getString("name"),
                                rst.getString("position"),
                                rst.getString("date")
                        );
                        user.setId(rst.getInt("id"));

                        listTadzhiki.add(user);
                        conn.commit();
                        System.out.println(user);
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    System.err.println("<<<selectUserById>>> <<<rollback>>> " + e);
                } finally {
                    conn.setAutoCommit(true);
                }
            }
        return listTadzhiki;
    }
}
//        for (User printuser : listTadzhiki) {
//            System.out.println(printuser);
//        }

