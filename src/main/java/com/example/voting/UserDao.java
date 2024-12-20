package com.example.voting;

import main.java.com.example.voting.User;

public interface UserDao {
    void saveUser(User user);

    User getUserByUsername(String username);
}
