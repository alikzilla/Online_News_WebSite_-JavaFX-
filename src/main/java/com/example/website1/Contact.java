package com.example.website1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Contact {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private ImageView instaLabel;

    @FXML
    private ImageView logoLabel;

    @FXML
    private ImageView steamLabel;

    @FXML
    private ImageView tgLabel;


    @FXML
    void initialize() {

        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            backButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        backButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            backButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("Menu.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Nuspekov.kz");
            stage.show();
        });

        tgLabel.addEventHandler(MouseEvent.MOUSE_PRESSED , mouseEvent -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(String.valueOf("https://t.me/alikhanchou")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        instaLabel.addEventHandler(MouseEvent.MOUSE_PRESSED , mouseEvent -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(String.valueOf("https://www.instagram.com/nuspe4kovv/")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        steamLabel.addEventHandler(MouseEvent.MOUSE_PRESSED , mouseEvent -> {
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(String.valueOf("https://steamcommunity.com/profiles/76561198940362247/")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

//        void setQuestionsLink(){
//        questionsLink.setOnMouseClicked(mouseEvent -> {
//            try {
//                java.awt.Desktop.getDesktop().browse(java.net.URI.create(String.valueOf("https://t.me/helfemida")));
//                System.out.println("Link is clicked");
//            } catch (java.io.IOException e) {
//                System.out.println(e.getMessage());
//            }
//        });
//    }
    }
}