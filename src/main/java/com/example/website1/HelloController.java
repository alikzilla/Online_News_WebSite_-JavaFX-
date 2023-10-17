package com.example.website1;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label dontLabel;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private Button adminButton;

    @FXML
    private Label nameLabel;

    @FXML
    private PasswordField passTextField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView porscheImage;

    @FXML
    private Button forgotPassword;

    @FXML
    private CheckBox remember;

    @FXML
    private AnchorPane loginBack;

    @FXML
    private Label noNameLabel;

    @FXML
    private Label noPassLabel;

    File file = new File("C:\\Users\\User\\IdeaProjects\\WebSite1\\src\\main\\java\\com\\example\\website1\\Employees\\Remember.txt");

    String[] data1 = new String[2];


    @FXML
    void initialize() {

        if(file.exists()){
            update();
        }

        signInButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            signInButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        signInButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            signInButton.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        signUpButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            signUpButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        signUpButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            signUpButton.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        forgotPassword.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            forgotPassword.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        forgotPassword.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            forgotPassword.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        adminButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            adminButton.setTextFill(Color.BLACK);
        });

        adminButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            adminButton.setTextFill(Color.RED);
        });

        adminButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            adminButton.setStyle("-fx-background-color: #b30000 ; -fx-background-radius:30");
        });

        adminButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            adminButton.setStyle("-fx-background-color: #000000 ; -fx-background-radius:30");
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

        signUpButton.setOnAction(event -> {
            signUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Nuspekov.kz");
            stage.showAndWait();

        });

        adminButton.setOnAction(event -> {
            adminButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("admin.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Nuspekov.kz");
            stage.showAndWait();

        });

        forgotPassword.setOnAction(event -> {
            forgotPassword.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("forgot.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Nuspekov.kz");
            stage.showAndWait();

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

                alert("Info", "Info is not correct");

            }

            if (info.get(0).equals(login) && info.get(1).equals(password)) {

                if(remember.isSelected()){
                    rem(login, password);
                }
                signInButton.getScene().getWindow().hide();
                showMenu();
                info.clear();


            } else {

                alert("error", "Wrong login or password");

            }

        } catch (FileNotFoundException e) {

            alert("User", "User not found");
            throw new RuntimeException(e);

        }
    }

    public void alert(String title, String content) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(title);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    public void infoAlert(String title, String content) {
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText(title);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    public void showMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Nuspekov.kz");
        stage.showAndWait();
    }

    public void rem(String login, String password){
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(login + " ");
            fw.write(password);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data1 = data.split(" " , 2);
                System.out.println(Arrays.toString(data1));
            }
            myReader.close();
            loginTextField.setText(data1[0]);
            passTextField.setText(data1[1]);
            file.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}