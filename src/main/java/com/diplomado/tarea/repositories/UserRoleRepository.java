package com.diplomado.tarea.repositories;

import com.diplomado.tarea.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByRoles_Id(Integer roleId);
    List<UserRole>findAllByUsers_Id(Long userId);
}
