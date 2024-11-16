package com.kirilin.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String name;

    private String lastName;

    private String login;

    private String password;

    public User(String name, String lastname, String login, String password) {
        this.name = name;
        this.lastName = lastname;
        this.login = login;
        this.password = password;
    }
}
