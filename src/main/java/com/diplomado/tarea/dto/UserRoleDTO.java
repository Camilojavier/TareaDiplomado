package com.diplomado.tarea.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public final class UserRoleDTO implements Serializable {
    private Integer id;
    private Boolean active;
    private LocalDateTime createdAt;
    private UserDTO users;
    private RoleDTO roles;

    public UserRoleDTO() {
    }
}
