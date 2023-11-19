package com.diplomado.tarea.dto;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public final class UserRoleDTO implements Serializable {
    private Integer id;
    private Boolean active;
    private Timestamp createdAt;
    private User users;
    private Role roles;

    public UserRoleDTO() {
    }
}
