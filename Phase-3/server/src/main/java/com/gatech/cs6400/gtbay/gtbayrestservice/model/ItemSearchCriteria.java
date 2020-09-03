package com.gatech.cs6400.gtbay.gtbayrestservice.model;

public class ItemSearchCriteria {
    private String keyword, category;
    private Double minPrice, maxPrice;
    private Integer conditionAtLeast;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getConditionAtLeast() {
        return conditionAtLeast;
    }

    public void setConditionAtLeast(Integer conditionAtLeast) {
        this.conditionAtLeast = conditionAtLeast;
    }
}
