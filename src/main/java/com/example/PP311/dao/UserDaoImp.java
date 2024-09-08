package com.example.PP311.dao;

import com.example.PP311.model.User;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (entityManager.find(User.class, id) != null) {
            entityManager.remove(entityManager.find(User.class, id));
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
