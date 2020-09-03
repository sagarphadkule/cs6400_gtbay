package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Bid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bidDao")
public class BidDaoImpl implements BidDao {

    @Autowired JdbcTemplate jdbcTemplate;

    @Override
    public void createBid(Bid bid) {
        jdbcTemplate.update(String.format("INSERT INTO Bid(BidItemId, bidByUser, amount, timestamp) " +
                        "VALUES('%d','%s','%f','%s');",
                bid.getBidItemId(), bid.getBidByUser(), bid.getAmount(), new Timestamp(new Date().getTime())));
    }


    //If Bid > getItNowPrice
    //  Msg "Bid is too high, use GetItNow
    //...

    //Get latest value for current highest bid for item again in case it
    //has changed during the time that user viewed the page.
    //SELECT bidItemId AS item_id,
    //MAX(amount) AS current_highest_bid
    //FROM Bid WHERE bidItemId = '$item_id';


    //If $amount >= current_highest_bid + 1 AND $amount < getItNowPrice:
    //Write to the Bid table
    //..
    //INSERT INTO Bid (bid_item_id, bid_by_user, amount, timestamp)
    //VALUES ('$item_id', '$user_id', '$amount', '$timestamp')
    //Display successful message
    //msg
    //Return to Search Results page

    @Override
    public List<Bid> getBidsByItemId(int id) {
        return jdbcTemplate.query(
            String.format("SELECT * FROM Bid WHERE bidItemId = '%d' ORDER BY amount DESC LIMIT 4", id), (resultSet, i) -> {
                Bid bid = new Bid();
                bid.setAmonut(resultSet.getDouble("amount"));
                bid.setBidByUser(resultSet.getString("bidByUser"));
                bid.setTimestamp(resultSet.getTimestamp("timestamp"));
                return bid;
            });
    }

}
