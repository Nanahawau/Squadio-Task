package com.squadio.accountstatements.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="UserTb_seqgen")
    @SequenceGenerator(name="UserTb_seqgen", sequenceName="User_SEQ",allocationSize=1)
    private Long id;
    @Column(name = "username", unique = true)
    private String userName;
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName.toLowerCase();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';

    }
}
