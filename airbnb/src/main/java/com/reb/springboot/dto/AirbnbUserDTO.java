package com.reb.springboot.dto;

import java.io.Serializable;
import com.reb.springboot.AirbnbUser;

public class AirbnbUserDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer userId;

	private String login;
    private String password;
    
	private String name;
    private String email;
    
    private int age;
    private String adresse;

	public AirbnbUserDTO() {}

    public AirbnbUserDTO(AirbnbUser user) {
        setLogin(user.getUsername());
        setPassword(user.getPassword());
        setAge(user.getAge());
        setAdresse(user.getAdresse());
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}