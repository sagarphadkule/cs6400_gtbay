package com.gatech.cs6400.gtbay.resources.register;

import com.gatech.cs6400.gtbay.models.rest.registration.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.gatech.cs6400.gtbay.constants.ResourceConstants.REGISTER;

@RestController
public class RegisterResource {

    @PostMapping(value = REGISTER, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
