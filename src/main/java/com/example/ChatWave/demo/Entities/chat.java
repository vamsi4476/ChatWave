package com.example.ChatWave.demo.Entities;


import jakarta.persistence.*;

@Entity
@Table(name="chat")
public class chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user1")
    private int user1;

    @Column(name="user2")
    private int user2;

    public chat(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }
}
