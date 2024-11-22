package com.kirilin.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirilin.util.HttpClient;
import com.kirilin.util.HttpClientImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "weatherServlet", urlPatterns = "/weather")
public class WeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");

        if (city != null && !city.isEmpty()) {
            String weatherResponse = getWeatherResponse(city);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(weatherResponse);
            double temperature = rootNode.path("main").path("temp").asDouble();

            req.setAttribute("weatherData", temperature);
        }

        req.getRequestDispatcher("weather.jsp").forward(req, resp);
    }

    private static String getWeatherResponse(String city) {
        HttpClient client = new HttpClientImpl();

        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();

        headers.put("Content-type", "application/json");
        params.put("q", city);
        params.put("appid", "bd5e378503939ddaee76f12ad7a97608");
        params.put("units", "metric");


        String weatherResponse = client.get("http://api.openweathermap.org/data/2.5//weather", headers, params);
        return weatherResponse;
    }
}
