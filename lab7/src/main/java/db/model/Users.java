package db.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return getId() == users.getId() &&
                getLogin().equals(users.getLogin()) &&
                getPassword().equals(users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(){}

    public Users(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
