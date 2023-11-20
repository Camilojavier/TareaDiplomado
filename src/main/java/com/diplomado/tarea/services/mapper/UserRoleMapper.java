package com.diplomado.tarea.services.mapper;

import com.diplomado.tarea.domain.entities.UserRole;
import com.diplomado.tarea.dto.UserRoleDTO;
import org.springframework.stereotype.Component;

@Component
public final class UserRoleMapper implements CustomMapper<UserRoleDTO, UserRole> {
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public UserRoleMapper(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserRoleDTO toDto(UserRole userRole) {
        final UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setId(userRole.getId());
        userRoleDTO.setActive(userRole.getActive());
        userRoleDTO.setCreatedAt(userRole.getCreatedAt());
        userRoleDTO.setRoles(roleMapper.toDto(userRole.getRoles()));
        userRoleDTO.setUsers(userMapper.toDto(userRole.getUsers()));
        return userRoleDTO;
    }

    @Override
    public UserRole toEntity(UserRoleDTO userRoleDTO) {
        final UserRole userRole = new UserRole();
        userRole.setId(userRoleDTO.getId());
        userRole.setActive(userRoleDTO.getActive());
        userRole.setCreatedAt(userRoleDTO.getCreatedAt());
        userRole.setRoles(roleMapper.toEntity(userRoleDTO.getRoles()));
        userRole.setUsers(userMapper.toEntity(userRoleDTO.getUsers()));
        return userRole;
    }
}
