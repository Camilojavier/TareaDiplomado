package com.diplomado.tarea.domain.services;

import com.diplomado.tarea.domain.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User saveUser(final User user);

}
