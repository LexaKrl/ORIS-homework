package com.kirilin.servlet;

import com.kirilin.dto.UserRegistrationDto;
import com.kirilin.service.UserService;
import com.kirilin.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        new UserServiceImpl().register(new UserRegistrationDto(name, lastname, login, password));

        resp.sendRedirect("index.html");
    }
}
