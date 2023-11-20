package com.diplomado.tarea.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = Annotations.USER_TABLE_NAME)
public final class User implements Annotations{

    @Id
    @SequenceGenerator(name = USER_SEQUENCE, allocationSize = ALLOCATION_SIZE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Column(name = CREATED_AT, columnDefinition = TIMESTAMP)
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = USER_TABLE_NAME, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private UserDetail usersDetail;

    public User(String username, String password, String email, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    public User() {

    }
}
