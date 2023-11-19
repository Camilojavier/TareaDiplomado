package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.dto.UserRoleDTO;
import com.diplomado.tarea.repositories.UserRoleRepository;
import com.diplomado.tarea.services.UserRoleService;
import com.diplomado.tarea.services.mapper.UserRoleMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<UserRoleDTO> getUserRoles() {
        return userRoleRepository.findAll()
                .stream()
                .map(userRoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRoleDTO> getUserRole(Integer userRoleId) {
        return userRoleRepository.findById(userRoleId).map(userRoleMapper::toDto);

    }

    @Override
    public List<UserRoleDTO> getUsersByRole(Integer role) {
        return userRoleRepository.findAllByRoles_Id(role)
                .stream()
                .map(userRoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> getRolesByUser(Long user) {
        return userRoleRepository.findAllByUsers_Id(user)
                .stream()
                .map(userRoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> createUserRoles(UserRoleDTO... userRoles) {
        List<UserRoleDTO> createdUserRoles = userRoleRepository.saveAll(
                        Arrays.stream(userRoles)
                                .map(userRoleMapper::toEntity)
                                .collect(Collectors.toList())
                ).stream()
                .map(userRoleMapper::toDto)
                .collect(Collectors.toList());

        return createdUserRoles;
    }

    @Override
    public void deleteUserRole(Integer userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

    @Override
    public UserRoleDTO setInactive(Integer userRoleId) {
        return userRoleRepository.findById(userRoleId)
                .map(userRole -> {
                    userRole.setActive(false);
                    return userRoleMapper.toDto(userRole);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró UserRoleDTO con ID: " + userRoleId));
    }


}
