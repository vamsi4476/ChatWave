package com.example.ChatWave.demo.UserService;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.userDAO.UserDAOImpl;
import com.example.ChatWave.demo.userDAO.UserDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
