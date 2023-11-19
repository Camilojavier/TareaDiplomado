package com.diplomado.tarea.services;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getUsers();
    List<UserDetailDTO> getUsersDetailed();
    Optional<UserDTO> getUser(Long userId);
    Optional<UserDetailDTO> getUserDetailed(Long userId);
    UserDTO createUser(UserDTO user);
    void deleteUser(Long userId);

}
