package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.AuctionResult;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AuctionResultsDao {

    List<AuctionResult> fetchAuctionResults();

    void updateWinnersAndFinalSalePrice();
}
