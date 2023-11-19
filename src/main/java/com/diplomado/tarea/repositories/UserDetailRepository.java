package com.diplomado.tarea.repositories;

import com.diplomado.tarea.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    Optional<UserDetail> findByUsers_Id(Long userId);
    Optional<Void> deleteByUsers_Id(Long userId);
}
