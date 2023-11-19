package com.diplomado.tarea.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = Annotations.USER_ROLE_TABLE_NAME)
public final class UserRole implements Annotations{

    @Id
    @SequenceGenerator(name = USER_ROLE_SEQUENCE, allocationSize = ALLOCATION_SIZE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_ROLE_SEQUENCE)
    private Integer id;
    private Boolean active;
    @Column(name = CREATED_AT)
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = USER_ID)
    private User users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = ROLE_ID)
    private Role roles;

    public UserRole() {
    }

    public UserRole(Boolean active, Timestamp createdAt, User users, Role roles) {
        this.active = active;
        this.createdAt = createdAt;
        this.users = users;
        this.roles = roles;
    }
}
