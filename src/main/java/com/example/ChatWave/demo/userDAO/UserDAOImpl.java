package com.example.ChatWave.demo.userDAO;


import com.example.ChatWave.demo.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<User> findUser(User user){

        TypedQuery<User> theQuery=entityManager.createQuery("From User where userName=:theuserName and " +
                "passWord=:thepassWord",User.class);

        theQuery.setParameter("theuserName",user.getUserName());
        theQuery.setParameter("thepassWord",user.getPassWord());

        return theQuery.getResultList();
    }
}
