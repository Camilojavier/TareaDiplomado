package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.entities.UserDetail;
import com.diplomado.tarea.services.UserDetailService;
import com.diplomado.tarea.repositories.UserDetailRepository;
import com.diplomado.tarea.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;
    private final UserRepository userRepository;

    public UserDetailServiceImpl(final UserDetailRepository userDetailRepository, final UserRepository userRepository) {
        this.userDetailRepository = userDetailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetail getDetailByUser(final Long userId) {
        final User user = getUserById(userId);
        return userDetailRepository.findByUsers_Id(user.getId())
                .orElseThrow(() -> new RuntimeException("UserDetail no encontrado para el usuario con ID: " + userId));
    }

    @Override
    public UserDetail saveUserDetail(final Long userId, final UserDetail userDetail) {
        final User user = getUserById(userId);
        userDetail.setUser(user);
        return userDetailRepository.save(userDetail);
    }

    private User getUserById(final Long userId ) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
