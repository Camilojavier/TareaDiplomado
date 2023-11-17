package com.diplomado.tarea.domain.services.impl;

import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.services.UserService;
import com.diplomado.tarea.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(final User user) {
        return userRepository.save(user);
    }
}
