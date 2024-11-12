package com.kirilin.dto;

public class UserDto {
    private String name;
    private Integer score;
    private String login;

    public UserDto(String name, Integer score, String login) {
        this.score = score;
        this.login = login;
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
