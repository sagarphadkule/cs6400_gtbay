package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Bid;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Item;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.BidService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BidResource {

    BidService bidService;

    @Autowired
    public BidResource(BidService bidService) {
        this.bidService = bidService;
    }

    @RequestMapping(
            path = "/bidItem",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBid(@RequestBody Bid bid) {
        this.bidService.createBid(bid);
    }


    @RequestMapping(
        path = "/getBids/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bid> getBidsByItemId(@PathVariable("id") int id) {
        return this.bidService.getBidsByItemId(id);
    }

}
