package com.diplomado.tarea.web.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Integer roleId) {
        super("Rol con ID " + roleId + " no encontrado");
    }
}

