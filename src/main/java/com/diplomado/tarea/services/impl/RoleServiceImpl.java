package com.diplomado.tarea.services.impl;

import com.diplomado.tarea.dto.RoleDTO;
import com.diplomado.tarea.services.RoleService;
import com.diplomado.tarea.repositories.RoleRepository;
import com.diplomado.tarea.services.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> getRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RoleDTO> getRole(Integer roleId) {
        return roleRepository.findById(roleId).map(roleMapper::toDto);
    }

    @Override
    public RoleDTO createRole(RoleDTO role) {
        return  roleMapper.toDto(roleRepository.save(roleMapper.toEntity(role)));
    }

    @Override
    public void deleteRole(Integer roleId) {

        roleRepository.deleteById(roleId);

    }
}
