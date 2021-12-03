package com.webcrudsecurityboot.webcrudsecurityboot.service;


import com.webcrudsecurityboot.webcrudsecurityboot.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role show(Long id);
    void save(Role role);
    void update(Role updatedRole);
    void delete(Long id);
}
