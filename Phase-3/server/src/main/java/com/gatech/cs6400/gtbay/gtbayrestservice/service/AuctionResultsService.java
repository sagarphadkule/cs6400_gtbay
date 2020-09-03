package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.AuctionResultsDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.AuctionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionResultsService {

    @Autowired
    AuctionResultsDao auctionResultsDao;

    public List<AuctionResult> fetchAuctionResults() {

        // Update first the winners and final sales prices
        auctionResultsDao.updateWinnersAndFinalSalePrice();

        return auctionResultsDao.fetchAuctionResults();
    }


}
