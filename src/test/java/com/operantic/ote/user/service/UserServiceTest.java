package com.operantic.ote.user.service;

import com.operantic.ote.user.dao.UserDao;
import com.operantic.ote.user.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserDao dao;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        User user = new User();
        user.setFirstName("__firstName__");
        user.setLastName("__lastName__");
        user.setEmail("email_@email.com");

        when(dao.save(any(User.class))).thenReturn(user);
    }

    @Test
    public void whenSaveUser_CallDaoSaveMethod() {
        User save = userService.save(new User());

        assertNotNull(save);
    }

    @TestConfiguration
    public static class UserServiceTestContext {

        @Bean
        UserService getUserService() {
            return new UserServiceImpl();
        }
    }
}