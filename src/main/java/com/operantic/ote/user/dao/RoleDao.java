package com.operantic.ote.user.dao;

import com.operantic.ote.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
