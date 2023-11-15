package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);
}
