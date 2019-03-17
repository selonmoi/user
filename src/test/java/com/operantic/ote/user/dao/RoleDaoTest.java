package com.operantic.ote.user.dao;

import com.operantic.ote.user.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void whenSaveRightRole_ReturnRoleWithId() {
        Role role = new Role();
        role.setName("__Name__");

        Role saved = roleDao.save(role);

        assertNotNull("saved failed", saved);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenSaveBadRole_ReturnRoleWithId() {
        roleDao.save(new Role());
    }
}