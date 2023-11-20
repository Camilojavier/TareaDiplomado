package com.diplomado.tarea.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public final class UserDetailDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthday;
    private UserDTO user;

    public UserDetailDTO() {
    }

}
