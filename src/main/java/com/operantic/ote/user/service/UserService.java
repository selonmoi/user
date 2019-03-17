package com.operantic.ote.user.service;

import com.operantic.ote.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user);
}
