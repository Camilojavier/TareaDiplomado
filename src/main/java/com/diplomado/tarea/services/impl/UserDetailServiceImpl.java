package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.dto.UserDetailDTO;
import com.diplomado.tarea.repositories.UserDetailRepository;
import com.diplomado.tarea.services.UserDetailService;
import com.diplomado.tarea.services.mapper.UserDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;

    private final UserDetailMapper userDetailMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> getUserDetails() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDetailDTO> getUserDetail(Long userId) {
        return userDetailRepository.findByUsers_Id(userId).map(userDetailMapper::toDto);
    }

    @Override
    public UserDetailDTO createUserDetail(UserDetailDTO userDetail) {
        return  userDetailMapper.toDto(userDetailRepository.save(userDetailMapper.toEntity(userDetail)));

    }

    @Override
    public void deleteUserDetail(Long userId) {
        userDetailRepository.deleteByUsers_Id(userId);
    }
}
