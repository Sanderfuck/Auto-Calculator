package com.sander.autocalculator.service;

import com.sander.autocalculator.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
