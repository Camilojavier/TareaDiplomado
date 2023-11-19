package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.dto.UserDetailDTO;
import com.diplomado.tarea.repositories.UserDetailRepository;
import com.diplomado.tarea.repositories.UserRepository;
import com.diplomado.tarea.services.UserService;
import com.diplomado.tarea.services.mapper.UserDetailMapper;
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
    private final UserDetailRepository userDetailRepository;
    private final UserMapper userMapper;
    private final UserDetailMapper userDetailMapper;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository, UserMapper userMapper, UserDetailMapper userDetailMapper) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.userMapper = userMapper;
        this.userDetailMapper = userDetailMapper;
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
    public List<UserDetailDTO> getUsersDetailed() {
        return userDetailRepository.findAll().stream().map(userDetailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUser(Long userId) {
        return userRepository.findById(userId).map(userMapper::toDto);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDetailDTO> getUserDetailed(Long userId) {
        return userDetailRepository.findById(userId).map(userDetailMapper::toDto);
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
