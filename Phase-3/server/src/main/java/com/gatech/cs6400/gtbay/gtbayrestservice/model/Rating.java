package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.sql.Timestamp;

public class Rating {
    private String ratedByUser, comment, itemName;
    private int ratedItemId, stars;
    private Timestamp timestamp;
    private double avgStars;

    public double getAvgStars() {
        return avgStars;
    }

    public void setAvgStars(double avgStars) {
        this.avgStars = avgStars;
    }

    public String getRatedByUser() {
        return ratedByUser;
    }

    public void setRatedByUser(String ratedByUser) {
        this.ratedByUser = ratedByUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRatedItemId() {
        return ratedItemId;
    }

    public void setRatedItemId(int ratedItemId) {
        this.ratedItemId = ratedItemId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }
}
