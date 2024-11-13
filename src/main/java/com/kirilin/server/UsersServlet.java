package com.kirilin.server;

import com.kirilin.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.io.IOException;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", List.of(new UserDto("Ivan",56,"pow")));
        LOG.info("{} : set new list of users", req.getRemoteAddr());
        req.getRequestDispatcher("user.ftl").forward(req, resp);
    }
}
