package com.example.website1;

public class Users {
    String name;
    String surname;
    String email;
    String gender;
    String password;
    String login;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    Users(){

    }
    Users(String name, String surname, String email, String gender, String login, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return email;
    }

    public void setContact(String contact) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
