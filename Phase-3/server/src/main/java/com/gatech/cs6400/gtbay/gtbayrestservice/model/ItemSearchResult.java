package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.sql.Timestamp;

public class ItemSearchResult {
    private int id;
    private String name, highBidder;
    private Double currentBid, getItNowPrice;
    private Timestamp auctionEnds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighBidder() {
        return highBidder;
    }

    public void setHighBidder(String highBidder) {
        this.highBidder = highBidder;
    }

    public Double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Double currentBid) {
        this.currentBid = currentBid;
    }

    public Double getGetItNowPrice() {
        return getItNowPrice;
    }

    public void setGetItNowPrice(Double getItNowPrice) {
        this.getItNowPrice = getItNowPrice;
    }

    public Timestamp getAuctionEnds() {
        return auctionEnds;
    }

    public void setAuctionEnds(Timestamp auctionEnds) {
        this.auctionEnds = auctionEnds;
    }
}
