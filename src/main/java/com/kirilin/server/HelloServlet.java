package com.kirilin.server;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;
import java.util.stream.Collectors;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello!");
        LOG.info("{} :  GET request successfully received", req.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(requestBody);
        LOG.info("{} : POST request successfully received", req.getRemoteAddr());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(requestBody);
        LOG.info("{} : DELETE request successfully received", req.getRemoteAddr());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println(requestBody);
        LOG.info("{} : PUT request successfully received", req.getRemoteAddr());
    }
}
