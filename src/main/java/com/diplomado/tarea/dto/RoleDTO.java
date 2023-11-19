package com.diplomado.tarea.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public final class RoleDTO implements Serializable {
    private Integer id;
    private String name;

    public RoleDTO() {
    }
}
