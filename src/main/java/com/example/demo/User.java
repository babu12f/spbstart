package com.example.demo;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    private String name;
    private Integer salary;
    private String teamName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserLog> userLogs;

    public User() {
    }

    public List<UserLog> getUserLogs() {
        return userLogs;
    }

    public User setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public User setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public User setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }
}