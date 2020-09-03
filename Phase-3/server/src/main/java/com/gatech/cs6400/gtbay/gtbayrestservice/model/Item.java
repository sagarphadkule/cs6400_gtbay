package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.sql.Timestamp;
import java.util.List;

public class Item {
    private int id;
    private Integer auctionLength, itemCondition;
    private Double startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice;
    private String name;
    private String description;
    private String listedByUser;
    private String winner;
    private String category;
    private String itemConditionName;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    private String condition;
    private boolean returnable;
    private Timestamp auctionEndTime;
    private List<Bid> bidList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAuctionLength() {
        return auctionLength;
    }

    public void setAuctionLength(Integer auctionLength) {
        this.auctionLength = auctionLength;
    }

    public Integer getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(Integer condition) {
        this.itemCondition = condition;
    }

    public Double getStartingBidPrice() {
        return startingBidPrice;
    }

    public void setStartingBidPrice(Double startingBidPrice) {
        this.startingBidPrice = startingBidPrice;
    }

    public Double getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(Double minSalePrice) {
        this.minSalePrice = minSalePrice;
    }

    public Double getGetItNowPrice() {
        return getItNowPrice;
    }

    public void setGetItNowPrice(Double getItNowPrice) {
        this.getItNowPrice = getItNowPrice;
    }

    public Double getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(Double finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListedByUser() {
        return listedByUser;
    }

    public void setListedByUser(String listByUser) {
        this.listedByUser = listByUser;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isReturnable() {
        return returnable;
    }

    public void setReturnable(boolean returnable) {
        this.returnable = returnable;
    }

    public Timestamp getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Timestamp auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public String getItemConditionName() {
        return itemConditionName;
    }

    public void setItemConditionName(String itemConditionName) {
        this.itemConditionName = itemConditionName;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }
}
