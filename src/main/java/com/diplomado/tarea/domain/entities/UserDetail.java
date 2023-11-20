package com.diplomado.tarea.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = Annotations.USER_DETAIL_TABLE_NAME)
public final class UserDetail implements Annotations{
    @Id
    @SequenceGenerator(name = USER_DETAIL_SEQUENCE, allocationSize = ALLOCATION_SIZE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_DETAIL_SEQUENCE)
    private Long id;
    @Column(name = FIRST_NAME)
    private String firstName;
    @Column(name = LAST_NAME)
    private String lastName;
    private Integer age;
    private Date birthday;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = USER_ID, unique = true)
    private User users;

    public UserDetail(String firstName, String lastName, Integer age, Date birthday, User users) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.users = users;
    }

    public UserDetail() {
    }
}
