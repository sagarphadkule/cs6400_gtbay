package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.User;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            path = "/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody User user) {
        this.userService.createUser(user);
    }

    @RequestMapping(
            path = "/users/{username}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE    )
    public User getUserByUsername(@PathVariable("username") String username) {
        return this.userService.getUserByUsername(username);
    }

    @RequestMapping(
            path = "/users/{username}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE    )
    public User getUserByUsernameAndPassword(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {
        return this.userService.getUserByUsernameAndPassword(username, password);
    }
}
