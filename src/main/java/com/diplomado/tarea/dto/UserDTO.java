package com.diplomado.tarea.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public final class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;

    public UserDTO() {
    }
}
