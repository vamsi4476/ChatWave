package com.example.ChatWave.demo.UserService;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.Entities.chat_friends;
import com.example.ChatWave.demo.userDAO.UserDAOImpl;
import com.example.ChatWave.demo.userDAO.UserDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO){
        this.userDAO=userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findUser(User user){

        return userDAO.findUser(user);
    }

    @Override
    public List<chat_friends> findAll(int id) {
        return userDAO.findAll(id);
    }

    public User findById(int n){
        return userDAO.findById(n);
    }
}
