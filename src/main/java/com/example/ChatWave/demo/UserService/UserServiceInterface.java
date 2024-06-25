package com.example.ChatWave.demo.UserService;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.Entities.chat_friends;

import java.util.List;

public interface UserServiceInterface {

    void save(User user);

    List<User> findUser(User user);

    List<chat_friends> findAll(int id);

    User findById(int n);   // To find UserById
}
