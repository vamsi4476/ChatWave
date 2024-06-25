package com.example.ChatWave.demo.Entities;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="chat_line")
public class chat_line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private BigInteger id;

    @Column(name="chat_id")
    private int chat_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="line_text")
    private String line_text;


    @Column(name="created_at")
    private LocalDateTime created_at;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLine_text() {
        return line_text;
    }

    public void setLine_text(String line_text) {
        this.line_text = line_text;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public chat_line(){

    }

}
