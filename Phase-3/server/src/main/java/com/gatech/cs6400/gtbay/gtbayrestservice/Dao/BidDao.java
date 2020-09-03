package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Bid;
import java.util.List;

public interface BidDao {
    abstract void createBid(Bid bid);

    List<Bid> getBidsByItemId(int id);

}
