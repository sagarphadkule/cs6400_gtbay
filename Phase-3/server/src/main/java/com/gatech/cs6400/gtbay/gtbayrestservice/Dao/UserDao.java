package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.User;

import java.util.List;

public interface UserDao {
    public abstract void createUser(User user);
    public abstract User getUserByUsername(String username);
    public abstract User getUserByUsernameAndPassword(String username, String password);
}
