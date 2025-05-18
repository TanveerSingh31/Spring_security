package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    @PostMapping(path="/api/login")
    public String login(@RequestBody User userObj) {

        System.out.println(userObj);

        // getting the authentication Object from auth Manager
        Authentication authObj = authManager.authenticate(new UsernamePasswordAuthenticationToken(userObj.userName, userObj.password));

        // check if authenticated
        if(authObj.isAuthenticated()) {
            // user entered correct username, pass
            // create and send the jwt token back to user

            return jwtService.generateToken(userObj.userName);
        }
        else {
            return "Wrong username pass";
        }


    }


    @GetMapping(path="/api/private")
    public String getPrivateData() {
        return "data";
    }

}
