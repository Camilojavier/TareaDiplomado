package com.diplomado.tarea.services;

import com.diplomado.tarea.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getUsers();
    Optional<UserDTO> getUser(final Long userId);
    UserDTO saveUser(final UserDTO user);
    void delete(final Long userId);

}
