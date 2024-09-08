package com.example.PP311.dao;



import com.example.PP311.model.User;

import java.util.List;


public interface UserDao {
    List<User> getAllUsers(int count);
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
}
