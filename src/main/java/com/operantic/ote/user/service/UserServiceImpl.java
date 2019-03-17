package com.operantic.ote.user.service;

import com.operantic.ote.user.dao.UserDao;
import com.operantic.ote.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User save(@NotNull User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User update(@NotNull User user) {
        Optional<User> found = userDao.findById(user.getId());
        found.orElseThrow(() ->
        {
            String message = MessageFormat.format("L''utilisateur avec l''identifiant {0} {1} n''existe pas.",
                    user.getFirstName(), user.getLastName());
            return new RuntimeException(message);
        });

        return userDao.save(user);
    }
}
