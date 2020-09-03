package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.sql.Timestamp;

public class Bid {
    private String bidByUser;
    private int bidItemId;
    private double amount;
    private Timestamp timestamp;

    public String getBidByUser() {
        return bidByUser;
    }

    public void setBidByUser(String bidByUser) {
        this.bidByUser = bidByUser;
    }

    public int getBidItemId() {
        return bidItemId;
    }

    public void setBidItemId(int bidItemId) {
        this.bidItemId = bidItemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmonut(double amonut) {
        this.amount = amonut;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
