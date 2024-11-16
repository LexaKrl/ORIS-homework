package com.kirilin.servlet;


import com.kirilin.service.UserService;
import com.kirilin.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (login != null) {
            req.setAttribute("users", List.of(userService.getByLogin(login)));
        } else {
            req.setAttribute("users", userService.getAll());
        }
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
