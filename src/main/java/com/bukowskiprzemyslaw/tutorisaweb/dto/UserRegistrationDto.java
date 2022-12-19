package com.bukowskiprzemyslaw.tutorisaweb.dto;

public class UserRegistrationDto {

    private String login;

    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
