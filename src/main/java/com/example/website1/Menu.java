package com.example.website1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane busBack;

    @FXML
    private Button busButton;

    @FXML
    private Button contactButton;

    @FXML
    private AnchorPane econBack;

    @FXML
    private Button econButton;

    @FXML
    private ImageView logoLabel;

    @FXML
    private Button outButton;

    @FXML
    private AnchorPane sportBack;

    @FXML
    private Button sportButton;

    @FXML
    private AnchorPane techBack;

    @FXML
    private Button techButton;

    ScaleTransition sc = new ScaleTransition();

    @FXML
    void initialize() {

        sportButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            sportButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        sportButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            sportButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        sportButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            sportButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        sportButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            sportButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        econButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            econButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        econButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            econButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        busButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            busButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        busButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            busButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        techButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            techButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        techButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            techButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        outButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            outButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        outButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            outButton.setStyle("-fx-background-color:  #6E6E6E ; -fx-background-radius:30");
        });

        contactButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            contactButton.setTextFill(Color.ORANGE);
        });

        contactButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            contactButton.setTextFill(Color.WHITE);
        });

        sportButton.setOnAction(event -> {
            sportButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("Sport.fxml"));

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

        techButton.setOnAction(event -> {
            sportButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("Tech.fxml"));

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

        econButton.setOnAction(event -> {
            sportButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("Economy.fxml"));

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

        busButton.setOnAction(event -> {
            sportButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("Business.fxml"));

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

        contactButton.setOnAction(event -> {
            contactButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("contact.fxml"));

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

        outButton.setOnAction(event -> {
            outButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("hello-view.fxml"));

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
    }

}
