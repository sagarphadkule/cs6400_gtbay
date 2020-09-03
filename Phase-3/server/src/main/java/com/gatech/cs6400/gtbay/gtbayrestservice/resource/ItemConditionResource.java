package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemCondition;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.ItemConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemConditionResource {

    private final ItemConditionService itemConditionService;

    @Autowired
    public ItemConditionResource(ItemConditionService itemConditionService) {
        this.itemConditionService = itemConditionService;
    }

    @RequestMapping(
            path = "/itemconditions",
            method = RequestMethod.GET)
    public ArrayList<String> getItemConditions() {

        ArrayList<String> res = new ArrayList<>();

        for (ItemCondition itemCondition: itemConditionService.getItemConditions()) {
            res.add(itemCondition.getConditionName());
        }
        return res;
    }

    @RequestMapping(
            path = "/itemconditions/{name}",
            method = RequestMethod.GET)
    public int getItemConditions(@PathVariable("name") String name) {

        return this.itemConditionService.getConditionValueByConditionName(name);
    }
}

