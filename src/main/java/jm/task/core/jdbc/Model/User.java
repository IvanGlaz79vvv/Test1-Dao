package jm.task.core.jdbc.Model;

import jm.task.core.jdbc.Dao.Dao;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.SQLException;

public class User {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String position;

    @Column
    private String date;

    public User() {
    }

    public User(int id, String name, String position, String date) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "User id = " + getId() + ";\t" +
                " name = " + getName() + ";\t" +
                " position = " + getPosition() + ";\t" +
                " date = " + getDate()
        );
    }
}
