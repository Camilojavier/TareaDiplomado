package com.diplomado.tarea.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public final class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    public UserDTO() {
    }
}
