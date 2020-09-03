package com.gatech.cs6400.gtbay.gtbayrestservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

// The Auction Results screen (see Figure 8) shows information about auctions that have ended. The fields
//shown are the Item ID, the Item Name, the final sale price, the Username of the Winner, and the
//Date and Time that the auction ended. This list should only include information about auctions that
//have already ended. The list should be sorted by the auction end date/time with the most recently ended
//auction listed first and can display all results at once, or if desired, paginated. The list is static;
//navigation to any other screens from rows in the list is not possible.

public class AuctionResult {
    private int itemId;
    private String itemName;
    private String salePrice;
    private String winner; // username

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Timestamp getAuctionEndTimeStamp() {
        return auctionEndTimeStamp;
    }

    public void setAuctionEndTimeStamp(Timestamp auctionEndTimeStamp) {
        this.auctionEndTimeStamp = auctionEndTimeStamp;
    }

    private Timestamp auctionEndTimeStamp;




}
