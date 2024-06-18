package com.example.ChatWave.demo.userDAO;


import com.example.ChatWave.demo.Entities.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAOInterface{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public void save(User user){

        entityManager.persist(user);
    }
}
