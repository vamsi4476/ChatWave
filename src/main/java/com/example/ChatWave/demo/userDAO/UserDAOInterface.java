package com.example.ChatWave.demo.userDAO;

import com.example.ChatWave.demo.Entities.User;

import java.util.List;

public interface UserDAOInterface {

   void save(User user);

   List<User> findUser(User user);
}
