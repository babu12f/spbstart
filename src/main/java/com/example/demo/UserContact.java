package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "user_contacts")
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer phoneNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    public UserContact() {
    }

    public User getUser() {
        return user;
    }

    public UserContact setUser(User user) {
        this.user = user;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UserContact setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public UserContact setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }
}
