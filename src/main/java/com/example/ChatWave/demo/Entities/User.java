package com.example.ChatWave.demo.Entities;

import jakarta.persistence.*;


// This entity is for users table. "id" is the primary key and it has username and password.
// Username has to be unique

@Entity
@Table(name="user")
public class User {


    @Id            // For Primary Key
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String passWord;

    public User(){
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
