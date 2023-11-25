package com.diplomado.tarea.services;

import com.diplomado.tarea.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    List<UserDetailDTO> getUserDetails();
    Optional<UserDetailDTO> getUserDetail(Long userId);
    UserDetailDTO createUserDetail(UserDetailDTO detail);

}
