package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.repositories.UserRepository;
import com.diplomado.tarea.services.UserService;
import com.diplomado.tarea.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(final UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUser(final Long userId) {
        return userRepository.findById(userId).map(userMapper::toDTO);

    }

    @Override
    public UserDTO saveUser(final UserDTO user) {
        return  userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public void delete(final Long userId) {
        userRepository.deleteById(userId);
    }
}
