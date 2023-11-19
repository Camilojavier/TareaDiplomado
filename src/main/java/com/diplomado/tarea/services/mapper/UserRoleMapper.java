package com.diplomado.tarea.services.mapper;

import com.diplomado.tarea.domain.entities.UserRole;
import com.diplomado.tarea.dto.UserRoleDTO;
import org.springframework.stereotype.Component;

@Component
public final class UserRoleMapper implements CustomMapper<UserRoleDTO, UserRole> {
    @Override
    public UserRoleDTO toDto(UserRole userRole) {
        final UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setId(userRole.getId());
        userRoleDTO.setActive(userRole.getActive());
        userRoleDTO.setCreatedAt(userRole.getCreatedAt());
        userRoleDTO.setRoles(userRole.getRoles());
        userRoleDTO.setUsers(userRole.getUsers());
        return userRoleDTO;
    }

    @Override
    public UserRole toEntity(UserRoleDTO userRoleDTO) {
        final UserRole userRole = new UserRole();
        userRole.setId(userRoleDTO.getId());
        userRole.setActive(userRoleDTO.getActive());
        userRole.setCreatedAt(userRoleDTO.getCreatedAt());
        userRole.setRoles(userRoleDTO.getRoles());
        userRole.setUsers(userRoleDTO.getUsers());
        return userRole;
    }
}
