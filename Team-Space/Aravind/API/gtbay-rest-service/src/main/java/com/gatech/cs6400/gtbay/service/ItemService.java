package com.gatech.cs6400.gtbay.service;

import com.gatech.cs6400.gtbay.dao.impl.ItemDaoImpl;
import com.gatech.cs6400.gtbay.models.domain.ItemDTO;
import com.gatech.cs6400.gtbay.models.rest.item.AddItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDaoImpl itemDao;

    public void addItem(AddItemRequest addItemRequest, String username) {
        itemDao.insertItem(convertAddItemRequestToItem(addItemRequest), username);
    }

    public ItemDTO getItem(Integer itemId) {
        return itemDao.retrieveItem(itemId);
    }


    private ItemDTO convertAddItemRequestToItem(AddItemRequest addItemRequest) {
        ItemDTO itemDto = new ItemDTO();
        itemDto.setName(addItemRequest.getName());
        itemDto.setDescription(addItemRequest.getDescription());
        itemDto.setStartingBidPrice(addItemRequest.getStartingBidPrice());
        itemDto.setMinimumSalePrice(addItemRequest.getMinimumSalePrice());
        itemDto.setGetItNowPrice(addItemRequest.getGetItNowPrice());
        itemDto.setAuctionLength(addItemRequest.getAuctionLength());
        itemDto.setReturnable(addItemRequest.isReturnable());
        itemDto.setCategory(addItemRequest.getCategory());
        itemDto.setCondition(addItemRequest.getCondition());
        return itemDto;

    }

}
