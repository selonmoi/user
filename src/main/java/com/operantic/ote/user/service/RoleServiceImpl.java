package com.operantic.ote.user.service;

import com.operantic.ote.user.dao.RoleDao;
import com.operantic.ote.user.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role save(@NotNull Role role) {
        return roleDao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public Role update(@NotNull Role role) {
        Optional<Role> found = roleDao.findById(role.getId());
        found.orElseThrow(() ->
        {
            String message = MessageFormat.format("Le role avec l''identifiant {0} n''existe pas.",
                    role.getId());
            return new RuntimeException(message);
        });

        return roleDao.save(role);
    }
}
