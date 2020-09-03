package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserReport implements Serializable {

    private String userName;
    private int listed;
    private int sold;
    private int purchased;
    private int rated;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getListed() {
        return listed;
    }

    public void setListed(int listed) {
        this.listed = listed;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }
}
