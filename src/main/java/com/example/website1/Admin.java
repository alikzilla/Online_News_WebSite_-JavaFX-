package com.example.website1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Admin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private Button signInButton;

    @FXML
    private CheckBox remember1;

    @FXML
    private Label noNameLabel;

    @FXML
    private Label noPassLabel;

    HelloController hc = new HelloController();

    @FXML
    void initialize() {
        signInButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            signInButton.setTextFill(Color.BLACK);
        });

        signInButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            signInButton.setTextFill(Color.RED);
        });

        signInButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            signInButton.setStyle("-fx-background-color: #b30000 ; -fx-background-radius:30");
        });

        signInButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            signInButton.setStyle("-fx-background-color: #000000 ; -fx-background-radius:30");
        });

        signInButton.setOnAction(event -> {

            String login = loginTextField.getText().trim();
            String password = passTextField.getText().trim();

            if(login.equals("")){
                noNameLabel.setText("Name is Empty");
            }else{
                noNameLabel.setText("");
            }
            if(password.equals("")){
                noPassLabel.setText("Pass is Empty");
            }else{
                noPassLabel.setText("");
            }

            if (!login.equals("") && !password.equals("")) {
                loginUser(login, password);
            }

        });

    }
    public void loginUser(String login, String password) {

        ArrayList<String> info = new ArrayList<>();

        try {

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\Users\\User\\IdeaProjects\\WebSite1\\src\\main\\java\\com\\example\\website1\\Employees\\" + login + ".txt"));
            try {

                String information = dataInputStream.readUTF();
                String information1 = dataInputStream.readUTF();
                String newInfo = information.substring(7);
                String newInfo1 = information1.substring(11);
                System.out.print(newInfo);
                System.out.print(newInfo1);
                info.add(newInfo);
                info.add(newInfo1);
                System.out.println(info);

            } catch (IOException e) {

                hc.alert("Info", "Info is not correct");

            }

            if (info.get(0).equals(login) && info.get(1).equals(password)) {

                hc.showMenu();
                info.clear();
                signInButton.getScene().getWindow().hide();

            } else {

                hc.alert("error", "Wrong login or password");

            }

        } catch (FileNotFoundException e) {

            hc.alert("File not found", "File not found");
            throw new RuntimeException(e);

        }
    }
}
