package ru.innopolis.sportgym.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Пользователь
 * Created by Кирилл on 17.10.2016.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    //Логин
    @Column(name = "email", unique = true)
    private String email;

    //Пароль
    @Column(name = "password")
    private String password;

    //Фамилия
    @Column(name = "surname")
    private String surname;

    //Имя
    @Column(name = "name")
    private String name;

    //Отчество
    @Column(name = "patronymic")
    private String patronymic;

    //Пользователь
    @OneToOne
    @JoinColumn(name = "id_sportsmen")
    private Sportsmen sportsmen;

    //Пол
    @Column(name = "gender")
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    //Актиность пользователя
    @Column(name = "active")
    private boolean active;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Sportsmen getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(Sportsmen sportsmen) {
        this.sportsmen = sportsmen;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (active != user.active) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) return false;
        if (sportsmen != null ? !sportsmen.equals(user.sportsmen) : user.sportsmen != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return roles != null ? roles.equals(user.roles) : user.roles == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (sportsmen != null ? sportsmen.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}