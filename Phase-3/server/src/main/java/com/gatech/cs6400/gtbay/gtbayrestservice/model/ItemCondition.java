package com.gatech.cs6400.gtbay.gtbayrestservice.model;

public class ItemCondition {
    private String conditionName;
    private int conditionValue;

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public int getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(int conditionValue) {
        this.conditionValue = conditionValue;
    }

    public ItemCondition(String conditionName, int conditionValue) {

        this.conditionName = conditionName;
        this.conditionValue = conditionValue;
    }
}
