package com.gatech.cs6400.gtbay.dao;

import com.gatech.cs6400.gtbay.models.domain.ItemDTO;

public interface ItemDao {

    void insertItem(ItemDTO item, String username);

    ItemDTO retrieveItem(Integer itemId);
}
