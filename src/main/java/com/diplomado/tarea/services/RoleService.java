package com.diplomado.tarea.services;

import com.diplomado.tarea.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleDTO> getRoles();
    Optional<RoleDTO> getRole(Integer roleId);
    RoleDTO createRole(RoleDTO role);
    void deleteRole(Integer roleId);

}
