package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.constant.Queries;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.AuctionResult;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.CategoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("auctionResultsDao")
public class AuctionResultsDaoImpl implements AuctionResultsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<AuctionResult> fetchAuctionResults() {

        System.out.println("Fetching Auction Results");

        return jdbcTemplate.query(Queries.FETCH_AUCTION_RESULTS, (resultSet, i) -> {

            AuctionResult auctionResult = new AuctionResult();
            auctionResult.setItemId(resultSet.getInt("id"));
            auctionResult.setItemName(resultSet.getString("name"));
            auctionResult.setSalePrice(resultSet.getString("finalSalePrice"));
            auctionResult.setWinner(resultSet.getString("winner"));
            auctionResult.setAuctionEndTimeStamp(resultSet.getTimestamp("auctionEndTime"));
            return auctionResult;
        });


    }

    @Override
    public void updateWinnersAndFinalSalePrice() {
        System.out.println("Updating Winners and Final Sale Price");
        jdbcTemplate.execute(Queries.UPDATE_WINNERS_AND_FINAL_SALE_PRICE);
    }
}
