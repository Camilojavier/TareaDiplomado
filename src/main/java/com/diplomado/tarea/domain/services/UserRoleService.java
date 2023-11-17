package com.diplomado.tarea.domain.services;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.entities.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> getUserRoles();
    List<UserRole> getUsersByRole(final Role role);
    List<UserRole> getRolesByUser(final User user);
    UserRole save(final UserRole userRole);
}
