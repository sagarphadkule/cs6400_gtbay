package com.gatech.cs6400.gtbay.models.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gatech.cs6400.gtbay.models.rest.item.BidInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ItemDTO {

    private Integer id;
    private String name;
    private String description;
    private String category;
    private String condition;
    private BigDecimal startingBidPrice;
    private BigDecimal minimumSalePrice;
    private BigDecimal getItNowPrice;
    private BigDecimal finalSalePrice;
    private Integer auctionLength;
    @JsonFormat
        (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private Date auctionEndTime;
    private boolean returnable;
    private String listedByUser;
    private String winner;
    private List<BidInfo> bidInfoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getStartingBidPrice() {
        return startingBidPrice;
    }

    public void setStartingBidPrice(BigDecimal startingBidPrice) {
        this.startingBidPrice = startingBidPrice;
    }

    public BigDecimal getMinimumSalePrice() {
        return minimumSalePrice;
    }

    public void setMinimumSalePrice(BigDecimal minimumSalePrice) {
        this.minimumSalePrice = minimumSalePrice;
    }

    public BigDecimal getGetItNowPrice() {
        return getItNowPrice;
    }

    public void setGetItNowPrice(BigDecimal getItNowPrice) {
        this.getItNowPrice = getItNowPrice;
    }

    public Integer getAuctionLength() {
        return auctionLength;
    }

    public void setAuctionLength(Integer auctionLength) {
        this.auctionLength = auctionLength;
    }

    public Date getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Date auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public boolean isReturnable() {
        return returnable;
    }

    public void setReturnable(boolean returnable) {
        this.returnable = returnable;
    }

    public String getListedByUser() {
        return listedByUser;
    }

    public void setListedByUser(String listedByUser) {
        this.listedByUser = listedByUser;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public BigDecimal getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(BigDecimal finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }

    public List<BidInfo> getBidInfoList() {
        return bidInfoList;
    }

    public void setBidInfoList(List<BidInfo> bidInfoList) {
        this.bidInfoList = bidInfoList;
    }
}
