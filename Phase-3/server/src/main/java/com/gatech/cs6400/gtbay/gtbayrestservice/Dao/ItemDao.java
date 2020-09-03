package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Item;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchCriteria;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchResult;

import java.util.ArrayList;

public interface ItemDao {
    public abstract void createItem(Item item);
    public abstract Item getItemById(int id);
    public abstract ArrayList<ItemSearchResult> search(ItemSearchCriteria criteria);
    public abstract void updateWinnerAndFinalSalePrice(String winner, double finalSalePrice, int id);

    void updateDescription(String description, int id);
}
