package com.example.ChatWave.demo.UserService;


import com.example.ChatWave.demo.Entities.User;

import java.util.List;

public interface UserServiceInterface {

    void save(User user);

    List<User> findUser(User user);
}
