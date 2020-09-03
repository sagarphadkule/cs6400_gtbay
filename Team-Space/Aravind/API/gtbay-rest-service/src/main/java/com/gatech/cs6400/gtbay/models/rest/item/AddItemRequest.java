package com.gatech.cs6400.gtbay.models.rest.item;


import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class AddItemRequest {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String category;
    @NotNull
    private String condition;
    @NotNull
    private BigDecimal startingBidPrice;
    @NotNull
    private BigDecimal minimumSalePrice;
    private BigDecimal getItNowPrice;
    @NotNull
    private Integer auctionLength;
    @NotNull
    private boolean returnable;

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

    public boolean isReturnable() {
        return returnable;
    }

    public void setReturnable(boolean returnable) {
        this.returnable = returnable;
    }
}
