package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Item;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemCondition;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchCriteria;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchResult;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.ItemConditionService;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemResource {

    private final ItemService itemService;
    private final ItemConditionService itemConditionService;

    @Autowired
    public ItemResource(ItemService itemService, ItemConditionService itemConditionService) {
        this.itemService = itemService;
        this.itemConditionService = itemConditionService;
    }

    @RequestMapping(
            path = "/items",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody Item item) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(item));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        item.setAuctionEndTime(this.incrementDayFromNow(item.getAuctionLength()));
        item.setItemCondition(this.itemConditionService.getConditionValueByConditionName(item.getItemConditionName()));
        this.itemService.createItem(item);
    }

    @RequestMapping(
            path = "/items/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@PathVariable("id") int id) {
        return this.itemService.getItemById(id);
    }

    @RequestMapping(
//            path = "/items/search?keyword={keyword}&category={category}&minPrice={minPrice}&" +
//                    "maxPrice={maxPrice}&condition={condition}",
            path = "/items/search/{keyword}/{category}/{condition}/{minPrice}/{maxPrice}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemSearchResult> search(@PathVariable("keyword") String keyword,
                                              @PathVariable("category") String category,
                                              @PathVariable("minPrice") double minPrice,
                                              @PathVariable("maxPrice") double maxPrice,
                                              @PathVariable("condition") String conditionAtLeast) {
        System.out.println(conditionAtLeast.equals(" "));
        ItemSearchCriteria criteria= new ItemSearchCriteria();
        criteria.setKeyword(keyword); //== " "? null: keyword);
        criteria.setCategory(category); //== " "? null : category);
        criteria.setMinPrice(minPrice);
        criteria.setMaxPrice(maxPrice);
        criteria.setConditionAtLeast(this.itemConditionService.getConditionValueByConditionName(conditionAtLeast));

        System.out.println(criteria.getKeyword());
        System.out.println(criteria.getCategory());
        System.out.println(criteria.getMinPrice());
        System.out.println(criteria.getMaxPrice());
        System.out.println(criteria.getConditionAtLeast());

        return this.itemService.search(criteria);
    }

    @RequestMapping(
            path = "/getItNow",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
            )
    public void updateWinnerAndFinalSalePrice(@RequestBody Item item) {
       this.itemService.updateWinnerAndFinalSalePrice(item.getWinner(), item.getGetItNowPrice(), item.getId());
    }

    @RequestMapping(
        path = "/updateDescription",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void updateItemDescription(@RequestBody Item item) {
        this.itemService.updateDescription(item.getDescription(), item.getId());
        System.out.println(item);
    }

    private Timestamp incrementDayFromNow(int day) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.DAY_OF_MONTH, day);
        return new Timestamp(cal.getTime().getTime());
    }
}
