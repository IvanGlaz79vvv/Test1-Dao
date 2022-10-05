package jm.task.core.jdbc.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

public class User {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String position;

    @Column
    private String date;

public User(){
    }

    public User(String name, String position, String date) {
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
        return String.format("" +
                "User id = %s, " +
                 "name = %s, " +
                "position = %s, " +
                "date = %d",
                getId(),
                getName(),
                getPosition(),
                getDate());
    }
}
