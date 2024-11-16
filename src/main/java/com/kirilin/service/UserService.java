package com.kirilin.service;

import com.kirilin.dto.UserDto;
import com.kirilin.dto.UserRegistrationDto;

import java.util.List;

import java.util.List;
public interface UserService {
    List<UserDto> getAll();
    UserDto get(Integer id);
    UserDto getByLogin(String login);
    void register(UserRegistrationDto user);
}