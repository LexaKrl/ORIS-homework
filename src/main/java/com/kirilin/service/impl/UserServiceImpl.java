package com.kirilin.service.impl;

import com.kirilin.dao.UserDao;
import com.kirilin.dao.impl.UserDaoImpl;
import com.kirilin.dto.UserDto;
import com.kirilin.dto.UserRegistrationDto;
import com.kirilin.entity.User;
import com.kirilin.service.UserService;
import com.kirilin.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getName(), null, u.getLastName())
        ).collect(Collectors.toList());
    }
    @Override
    public UserDto get(Integer id) {
        return null;
    }
    @Override
    public UserDto getByLogin(String login) {
        User u = userDao.getByLogin(login);
        return new UserDto(u.getName(), null, u.getLastName());
    }
    @Override
    public void register(UserRegistrationDto user) {
        userDao.save(new User(
                user.getName(),
                user.getLastname(),
                user.getLogin(),
                PasswordUtil.encrypt(user.getPassword())
        ));
    }
}
