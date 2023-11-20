package com.diplomado.tarea.web.exceptions;

public class UserByRoleNotFoundException extends RuntimeException {
    public UserByRoleNotFoundException(Integer userRoleId) {
        super("Usuarios del Rol con ID " + userRoleId + " no encontrado");
    }
}

