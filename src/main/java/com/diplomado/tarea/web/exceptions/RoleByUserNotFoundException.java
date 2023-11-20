package com.diplomado.tarea.web.exceptions;

public class RoleByUserNotFoundException extends RuntimeException {
    public RoleByUserNotFoundException(Long userRoleId) {
        super("Roles del usuario con ID " + userRoleId + " no encontrado");
    }
}
