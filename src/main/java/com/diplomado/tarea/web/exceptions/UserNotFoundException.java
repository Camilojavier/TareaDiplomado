package com.diplomado.tarea.web.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Usuario con ID " + userId + " no encontrado");
    }
}

