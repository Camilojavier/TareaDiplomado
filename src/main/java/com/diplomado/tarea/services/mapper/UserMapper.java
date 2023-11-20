package com.diplomado.tarea.services.mapper;

import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public final class UserMapper implements CustomMapper<UserDTO, User>{

    @Override
    public UserDTO toDto(User user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        final User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}
