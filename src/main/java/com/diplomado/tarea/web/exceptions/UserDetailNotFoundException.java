package com.diplomado.tarea.web.exceptions;

public class UserDetailNotFoundException extends RuntimeException {
    public UserDetailNotFoundException(Long userId) {
        super("Detalles del usuario con ID " + userId + " no encontrados");
    }
}

