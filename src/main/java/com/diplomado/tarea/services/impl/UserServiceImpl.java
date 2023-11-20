package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.repositories.UserRepository;
import com.diplomado.tarea.services.UserService;
import com.diplomado.tarea.services.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUser(Long userId) {
        return userRepository.findById(userId).map(userMapper::toDto);

    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return  userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
