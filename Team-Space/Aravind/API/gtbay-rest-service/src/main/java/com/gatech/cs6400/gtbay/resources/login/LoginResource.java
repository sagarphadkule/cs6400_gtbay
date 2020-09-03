package com.gatech.cs6400.gtbay.resources.login;

import com.gatech.cs6400.gtbay.models.rest.login.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.gatech.cs6400.gtbay.constants.ResourceConstants.LOGIN;

@RestController
public class LoginResource {
    @PostMapping(value = LOGIN, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> login(
            @RequestBody
                    LoginRequest request) {
        if (request.getUserName().equals("aravindram87") &&
                request.getPassword().equals("admin")) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
