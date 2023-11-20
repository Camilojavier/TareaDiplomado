package com.diplomado.tarea.repositories;

import com.diplomado.tarea.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
