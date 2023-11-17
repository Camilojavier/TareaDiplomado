package com.diplomado.tarea.domain.services.impl;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.services.RoleService;
import com.diplomado.tarea.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(final Role role) {
        return roleRepository.save(role);
    }
}
