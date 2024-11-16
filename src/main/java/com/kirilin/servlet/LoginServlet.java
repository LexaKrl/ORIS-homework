package com.kirilin.servlet;

import com.kirilin.dto.UserDto;
import com.kirilin.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
        LOG.info("{} : GET request successfully received", req.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");

        UserServiceImpl usi = new UserServiceImpl();
        UserDto user = usi.getByLogin(login);

        if (user != null && "password".equals(password)) {
            //session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", login);
            httpSession.setMaxInactiveInterval(60 * 60);

            //cookie
            Cookie cookie = new Cookie("user", login);
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
            LOG.info("{} : user successfully authenticate", req.getRemoteAddr());
            resp.sendRedirect("main.jsp");
            LOG.info("{} : POST request successfully received", req.getRemoteAddr());
        } else {
            resp.sendRedirect("/login");
        }
    }
}
