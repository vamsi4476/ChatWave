package com.example.ChatWave.demo.userDAO;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.Entities.chat_friends;
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

        int a=1;

        TypedQuery<User> theQuery=entityManager.createQuery("From User where userName=:theuserName and passWord=:thepassWord",User.class);

               // theQuery.setParameter("a",1);

        theQuery.setParameter("theuserName",user.getUserName());
        theQuery.setParameter("thepassWord",user.getPassWord());

        return theQuery.getResultList();
    }

    @Override
    public List<chat_friends> findAll(int id) {

        TypedQuery<chat_friends> theQuery=entityManager.createQuery("from chat_friends where friend1_id=:id",chat_friends.class);

        theQuery.setParameter("id",id);

        return theQuery.getResultList();
    }

    @Override
    public User findById(int n) {

        TypedQuery<User> theQuery=entityManager.createQuery("from User where id=:n",User.class);

        theQuery.setParameter("n",n);

        return theQuery.getResultList().get(0);
    }
}
