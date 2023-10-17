package com.example.website1;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Authorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField contactTextField;

    @FXML
    private RadioButton femaleButton;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private RadioButton maleButton;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private ImageView porscheImage;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label noEmailLabel;

    @FXML
    private Label noGenderLabel;

    @FXML
    private Label noLoginLabel;

    @FXML
    private Label noNameLabel;

    @FXML
    private Label noPassLabel;

    @FXML
    private Label noSurnameLabel;

    HelloController hc = new HelloController();

    @FXML
    void initialize() {

        ToggleGroup tg = new ToggleGroup();
        maleButton.setToggleGroup(tg);
        femaleButton.setToggleGroup(tg);

        signUpButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            signUpButton.setStyle("-fx-background-color:#6C8CD5 ; -fx-background-radius:30");
        });

        signUpButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            signUpButton.setStyle("-fx-background-color: #090974 ; -fx-background-radius:30");
        });

        signUpButton.setOnAction(event -> {

            String gender = "";
            String name = nameTextField.getText().trim();
            String surname = surnameTextField.getText().trim();
            String email = contactTextField.getText().trim();
            String login = loginTextField.getText().trim();
            String password = passTextField.getText().trim();

            if(login.equals("")){
                noLoginLabel.setText("Login is Empty");
            }else{
                noLoginLabel.setText("");
            }
            if(password.equals("")){
                noPassLabel.setText("Pass is Empty");
            }else{
                noPassLabel.setText("");
            }
            if(name.equals("")){
                noNameLabel.setText("Name is Empty");
            }else{
                noNameLabel.setText("");
            }
            if(surname.equals("")){
                noSurnameLabel.setText("Surname is Empty");
            }else{
                noSurnameLabel.setText("");
            }
            if(!maleButton.isSelected()){
                noGenderLabel.setText("Gender isn't selected");
            }else{
                noGenderLabel.setText("");
            }
            if(!femaleButton.isSelected()){
                noGenderLabel.setText("Gender isn't selected");
            }else{
                noGenderLabel.setText("");
            }
            if(email.equals("")){
                noEmailLabel.setText("Email is Empty");
            }else{
                noEmailLabel.setText("");
            }

            if (maleButton.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            if (login.length() > 8 && password.length() > 8 && email.length() > 8 && checkString(name) && checkString(surname)) {

                Users users = new Users(name, surname, email, gender, login, password);

                createFolder(users);

            } else {

                hc.alert("Input", "Invalid Input");

            }
        });
    }

    public void createFolder(Users users) {

        File file = new File("C:\\Users\\User\\IdeaProjects\\WebSite1\\src\\main\\java\\com\\example\\website1\\Employees\\" + users.getLogin() + ".txt");


        if(!file.exists()){
            try {

                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                dataOutputStream.writeUTF("Login: " + users.getLogin());
                dataOutputStream.writeUTF("\nPassword: " + users.getPassword());
                dataOutputStream.writeUTF("\nContact: " + users.getContact());
                dataOutputStream.writeUTF("\nName: " + users.getName());
                dataOutputStream.writeUTF("\nSurname: " + users.getSurname());
                dataOutputStream.writeUTF("\nGender: " + users.getGender());
                dataOutputStream.close();

                hc.infoAlert("Account", "Account successfully created");

                signUpButton.getScene().getWindow().hide();

                showLogin();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            hc.alert("User", "Login is already exists");
        }

    }

    public boolean checkString(String name) {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            count = 0;
        }
        return false;
    }

    public void showLogin(){
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
    }
}
