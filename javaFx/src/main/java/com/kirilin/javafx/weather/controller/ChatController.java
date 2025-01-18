package com.kirilin.javafx.weather.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.kirilin.javafx.weather.service.ChatService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ChatController {

    ChatService service = new ChatService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField serverText;

    @FXML
    private TextField userText;

    @FXML
    void sendMessage(ActionEvent event) throws IOException {
        List<String> answer = new ArrayList<>(List.of(userText.getText().split(" ")));

        String command = answer.get(0);

        if (command.equals("list")) {
            serverText.setText(
                    """
                        1) list - выводит все команды\n
                        2) q - выход из консоли\n
                        3) weather [city] - выдает погоду из города\n
                        4) exchange [rate] - выводит обменный курс валюты на рубль \n
                    """
            );
        } else if(command.equals("q")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kirilin/javafx/hello-view.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = (Stage) sendBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else if (command.equals("weather")) {
            serverText.setText(service.getWeather(answer.get(1)));
        } else if (command.equals("exchange")) {
            serverText.setText(service.getRate(answer.get(1)));
        }
    }

    @FXML
    void initialize() {
        userText.setOnAction(event -> {
            try {
                sendMessage(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
