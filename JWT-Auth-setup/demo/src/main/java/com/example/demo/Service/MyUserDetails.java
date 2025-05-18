package com.example.demo.Service;


import com.example.demo.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public class MyUserDetails implements UserDetails {


    public User userObj = null;

    public MyUserDetails(User obj) {
        userObj = obj;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userObj.password;
    }

    @Override
    public String getUsername() {
        return userObj.userName;
    }
}
