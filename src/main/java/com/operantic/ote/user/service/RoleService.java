package com.operantic.ote.user.service;

import com.operantic.ote.user.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);

    List<Role> findAll();

    Optional<Role> findById(int id);

    Role update(Role user);
}
