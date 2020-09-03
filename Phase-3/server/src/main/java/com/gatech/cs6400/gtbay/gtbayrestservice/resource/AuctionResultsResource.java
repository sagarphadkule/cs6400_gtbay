package com.gatech.cs6400.gtbay.gtbayrestservice.resource;


import com.gatech.cs6400.gtbay.gtbayrestservice.model.AuctionResult;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.AuctionResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuctionResultsResource {

    @Autowired
    AuctionResultsService auctionResultsService;

    @RequestMapping(
            path = "/auctionResults",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuctionResult> fetchAuctionResults() {
        return auctionResultsService.fetchAuctionResults();
    }


}
