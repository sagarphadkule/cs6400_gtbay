package com.gatech.cs6400.gtbay.models.rest.item;

import java.math.BigDecimal;
import java.util.Date;

public class SearchItemsResponse {

    private Integer itemId;
    private String itemName;
    private BigDecimal currentBid;
    private BigDecimal getItNowPrice;
    private String highBidder;
    private Date auctionEndTime;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(BigDecimal currentBid) {
        this.currentBid = currentBid;
    }

    public BigDecimal getGetItNowPrice() {
        return getItNowPrice;
    }

    public void setGetItNowPrice(BigDecimal getItNowPrice) {
        this.getItNowPrice = getItNowPrice;
    }

    public String getHighBidder() {
        return highBidder;
    }

    public void setHighBidder(String highBidder) {
        this.highBidder = highBidder;
    }

    public Date getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Date auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }
}
