package com.example.website1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Forgot {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginLabel;

    @FXML
    private Label loginLabel1;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    @FXML
    private Button showButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label noNameLabel;

    HelloController hc = new HelloController();

    @FXML
    void initialize() {

        showButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            showButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        showButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            showButton.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        exitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            exitButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        exitButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            exitButton.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        showButton.setOnAction(event -> {

            String login = loginTextField.getText().trim();

            if (!login.equals("")) {

                showPass(login);

            } else {

                noNameLabel.setText("Name is Empty or Incorrect");
            }
        });

        exitButton.setOnAction(event -> {

            exitButton.getScene().getWindow().hide();

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

    public void showPass(String login) {

        ArrayList<String> info = new ArrayList<>();

        try {

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\Users\\User\\IdeaProjects\\WebSite1\\src\\main\\java\\com\\example\\website1\\Employees\\" + login + ".txt"));
            try {

                String information = dataInputStream.readUTF();
                String information1 = dataInputStream.readUTF();
                String newInfo = information.substring(7);
                String newInfo1 = information1.substring(11);
                System.out.print(newInfo);
                info.add(newInfo);
                info.add(newInfo1);
                System.out.println(info);

            } catch (IOException e) {

                hc.alert("Info", "Info is not correct");

            }

            if (info.get(0).equals(login)){

                passTextField.setText(info.get(1));
                info.clear();

            } else {

                hc.alert("error", "Wrong Login");

            }

        } catch (FileNotFoundException e) {

            hc.alert("File not found", "File not found");
            throw new RuntimeException(e);

        }
    }
}