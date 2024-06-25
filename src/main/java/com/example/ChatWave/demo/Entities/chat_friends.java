package com.example.ChatWave.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="chat_friends")
public class chat_friends {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="friend1_id")
    private int friend1_id;

    @Column(name="friend2_id")
    private int friend2_id;

    public chat_friends(){

    }

    public int getFriend1_id() {
        return friend1_id;
    }

    public void setFriend1_id(int friend1_id) {
        this.friend1_id = friend1_id;
    }

    public int getFriend2_id() {
        return friend2_id;
    }

    public void setFriend2_id(int friend2_id) {
        this.friend2_id = friend2_id;
    }

    @Override
    public String toString() {
        return "chat_friends{" +
                "id=" + id +
                ", friend1_id=" + friend1_id +
                ", friend2_id=" + friend2_id +
                '}';
    }
}

