package com.kirilin.dao.impl;

import com.kirilin.dao.UserDao;
import com.kirilin.entity.User;
import com.kirilin.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        try {
            Statement statement = connection.createStatement();
            //language=sql
            String sql = "select * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            users = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    users.add(
                            User
                                    .builder()
                                    .name(resultSet.getString("name"))
                                    .lastName(resultSet.getString("last_name"))
                                    .login(resultSet.getString("login"))
                                    .password(resultSet.getString("password"))
                                    .build()
                    );
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getByLogin(String login) {
        try {
            String sql = "select * from users where login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("login"),
                            resultSet.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(User user) {
        //language=sql
        String sql = "insert into users(name, last_name, login, password) values (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
