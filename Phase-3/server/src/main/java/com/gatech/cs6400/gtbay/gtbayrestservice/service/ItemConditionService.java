package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.ItemConditionDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemConditionService {
    private final ItemConditionDao itemConditionDao;

    public ItemConditionService(@Qualifier("itemConditionDao") ItemConditionDao itemConditionDao) {
        this.itemConditionDao = itemConditionDao;
    }

    public ArrayList<ItemCondition> getItemConditions() {
        return itemConditionDao.getItemConditions();
    }

    public int getConditionValueByConditionName(String name) {
        return name.equals(" ")? -1: itemConditionDao.getConditionValueByConditionName(name);
    }
}
