package com.kirilin;

import com.kirilin.util.HttpClientImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HttpClientImpl httpClient = new HttpClientImpl();
        Map<String, String> header = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        // get

      /*  header.put("Content-Type", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("userId", "2");
        System.out.println(httpClient.get("https://jsonplaceholder.typicode.com/posts", header, params));*/

        // post
    /*    header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");
        header.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");

        data.put("name", "Sen. Anala 2Iye3r");
        data.put("email", "dsen_a1n1al1_iy632e1r123@stroman-leannon.test");
        data.put("gender", "female");
        data.put("status", "active");
        System.out.println(httpClient.post("http://localhost:8080/hello", header, data));*/

        //delete
/*        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");
        header.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");
        System.out.println(httpClient.delete("http://localhost:8080/hello", header, data));*/

        //put
/*        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json");
        header.put("Authorization", "Bearer 58762cdab4e248c10d165f6bbe89d18a444dff00267b6cfcec49acf9dceb94b7");

        data.put("name", "Oleg Tinkoff");
        data.put("email", "tinkoffoleg123@stroman-leannon.test");
        data.put("gender", "male");
        data.put("status", "active");
        System.out.println(httpClient.put("", header, data));*/
    }
}