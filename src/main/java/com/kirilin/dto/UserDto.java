package com.kirilin.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String lastname;
    private Integer score;

    public UserDto(String name, Integer score, String lastname) {
        this.score = score;
        this.name = name;
        this.lastname = lastname;
    }
}
