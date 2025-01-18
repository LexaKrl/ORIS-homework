package com.kirilin.javafx.weather.service;

import com.kirilin.javafx.weather.util.HttpClient;
import com.kirilin.javafx.weather.util.HttpClientImpl;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChatService {
    private final HttpClient httpClient = new HttpClientImpl();

    public String getWeather(String city) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> params = new HashMap<>();

        headers.put("Content-type", "application/json");
        params.put("q", city);
        params.put("appid", "bd5e378503939ddaee76f12ad7a97608");
        params.put("units", "metric");


        String weatherResponse = httpClient.get("http://api.openweathermap.org/data/2.5//weather", headers, params);
        return weatherResponse;
    }

    public String getRate(String rate) {
        String response = httpClient.get("https://v6.exchangerate-api.com/v6/%s/latest/%s".formatted("aebe42fc858f83411bf550a6", rate), new HashMap<>(), new HashMap<>());

        try {
            JSONObject jsonObject = new JSONObject(response);

            if (jsonObject.has("conversion_rates")) {
                double rubRate = jsonObject.getJSONObject("conversion_rates").getDouble("RUB");
                return "Answer: " + rubRate;
            } else {
                return "Error: Не найдено валюты.";
            }
        } catch (Exception e) {
            return "Error: Невозиожно конвертировать";
        }
    }
}
