package com.diplomado.tarea.services;

import com.diplomado.tarea.domain.entities.UserDetail;

public interface UserDetailService {
    UserDetail getDetailByUser(final Long userId);
    UserDetail saveUserDetail(final Long userId, final UserDetail detail);
}
