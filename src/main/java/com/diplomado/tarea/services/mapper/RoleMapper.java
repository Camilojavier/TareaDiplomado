package com.diplomado.tarea.services.mapper;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.dto.RoleDTO;
import org.springframework.stereotype.Component;

@Component
public final class RoleMapper implements CustomMapper<RoleDTO, Role> {
    @Override
    public RoleDTO toDto(Role role) {
        final RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    @Override
    public Role toEntity(RoleDTO roleDTO) {
        final Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }
}
