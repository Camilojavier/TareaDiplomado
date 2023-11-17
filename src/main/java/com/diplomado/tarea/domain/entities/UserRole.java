package com.diplomado.tarea.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @SequenceGenerator(name = "user_role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    private Integer id;
    private Boolean active;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roles;

    public UserRole() {
    }

    public UserRole(Boolean active, Timestamp createdAt, User users, Role roles) {
        this.active = active;
        this.createdAt = createdAt;
        this.users = users;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }
}
