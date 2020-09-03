package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemCondition;

import java.util.ArrayList;

public interface ItemConditionDao {
    public abstract ArrayList<ItemCondition> getItemConditions();
    public abstract int getConditionValueByConditionName(String name);
}
