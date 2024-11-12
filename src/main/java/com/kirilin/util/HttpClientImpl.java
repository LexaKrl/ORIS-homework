package com.kirilin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClientImpl implements HttpClient{
    @Override
    public String get(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            URL getUrl = new URL(url + paramsToString(params));
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", headers.get("Content-type"));
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.disconnect();
            return readResponse(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String post(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL postUrl = new URL(url);
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", headers.get("Content-type"));
            postConnection.setRequestProperty("Accept", headers.get("Accept"));
            postConnection.setRequestProperty("Authorization", headers.get("Authorization"));
            postConnection.setDoOutput(true);

            writeRequest(data, postConnection);

            System.out.println(postConnection.getResponseCode());
            postConnection.disconnect();
            return readResponse(postConnection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String put(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL putUrl = new URL(url);
            HttpURLConnection putConnection = (HttpURLConnection) putUrl.openConnection();
            putConnection.setRequestMethod("PUT");
            putConnection.setRequestProperty("Content-Type", headers.get("Content-type"));
            putConnection.setRequestProperty("Accept", headers.get("Accept"));
            putConnection.setRequestProperty("Authorization", headers.get("Authorization"));
            putConnection.setDoOutput(true);

            writeRequest(data, putConnection);

            System.out.println(putConnection.getResponseCode());
            putConnection.disconnect();
            return readResponse(putConnection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String delete(String url, Map<String, String> headers, Map<String, String> data) {
        try {
            URL deleteUrl = new URL(url);
            HttpURLConnection deleteConnection = (HttpURLConnection) deleteUrl.openConnection();
            deleteConnection.setRequestMethod("DELETE");
            deleteConnection.setRequestProperty("Content-Type", headers.get("Content type"));
            deleteConnection.setRequestProperty("Accept", headers.get("Accept"));
            deleteConnection.setRequestProperty("Authorization", headers.get("Authorization"));

            writeRequest(data, deleteConnection);

            System.out.println(deleteConnection.getResponseCode());
            System.out.println(readResponse(deleteConnection));
            deleteConnection.disconnect();
            return readResponse(deleteConnection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        if (connection != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            }
        }
        return null;
    }

    private static StringBuilder paramsToString(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        result.append("?");
        for (String str : params.keySet()) {
            result.append(str).append("=").append(params.get(str)).append("&");
        }
        return result.deleteCharAt(result.length() - 1);
    }

    private static void writeRequest(Map<String, String> params, HttpURLConnection connection) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInput = "";

        try {
            jsonInput = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
