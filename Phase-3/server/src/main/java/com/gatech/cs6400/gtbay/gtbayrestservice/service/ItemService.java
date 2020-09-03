package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.ItemDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Item;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchCriteria;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(@Qualifier("itemDao") ItemDao itemDao) { this.itemDao = itemDao; }

    public void createItem(Item item) {
//        Item item = new Item(item);

        this.itemDao.createItem(item);
    }

    public Item getItemById(int id) {
        return this.itemDao.getItemById(id);
    }

    public ArrayList<ItemSearchResult> search(ItemSearchCriteria criteria) {
        return this.itemDao.search(criteria);
    }

    public void updateWinnerAndFinalSalePrice(String winner, double finalSalePrice, int id) {
        this.itemDao.updateWinnerAndFinalSalePrice(winner, finalSalePrice, id);
    }

    public void updateDescription(String description, int id) {
        this.itemDao.updateDescription(description, id);
    }
}
