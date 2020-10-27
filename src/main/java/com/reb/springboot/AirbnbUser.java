package com.reb.springboot;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AirbnbUser extends User {

    public AirbnbUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        // TODO Auto-generated constructor stub
    }
    
    public AirbnbUser(UserDetails user)
    {
        super(user.getUsername(), user.getPassword(),user.getAuthorities());

    }

    public AirbnbUser(User user)
    {
        super(user.getPassword(), user.getPassword(),user.getAuthorities()); 

    }

    private int age;
    private String adresse;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

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