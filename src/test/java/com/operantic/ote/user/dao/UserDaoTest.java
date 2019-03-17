package com.operantic.ote.user.dao;

import com.operantic.ote.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void whenSaveRightUser_ReturnUserWithId() {
        User user = new User();
        user.setFirstName("__firstName__");
        user.setLastName("__lastName__");
        user.setEmail("email_@email.com");

        User saved = userDao.save(user);

        assertNotNull("saved failed", saved);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenSaveBadUser_ReturnUserWithId() {
        userDao.save(new User());
    }
}