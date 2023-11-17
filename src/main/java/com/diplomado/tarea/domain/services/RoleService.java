package com.diplomado.tarea.domain.services;

import com.diplomado.tarea.domain.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role save(final Role role);
}
