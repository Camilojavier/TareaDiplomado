package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.entities.UserRole;
import com.diplomado.tarea.services.UserRoleService;
import com.diplomado.tarea.repositories.RoleRepository;
import com.diplomado.tarea.repositories.UserRepository;
import com.diplomado.tarea.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserRoleServiceImpl(final UserRoleRepository userRoleRepository, final UserRepository userRepository, final RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserRole> getUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public List<UserRole> getUsersByRole(final Role role) {
        return userRoleRepository.findAllByRoles_Id(role.getId());
    }

    @Override
    public List<UserRole> getRolesByUser(final User user) {
        return userRoleRepository.findAllByUsers_Id(user.getId());
    }

    @Override
    public UserRole save(final UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void delete(Integer userRoleId) {

    }
}
