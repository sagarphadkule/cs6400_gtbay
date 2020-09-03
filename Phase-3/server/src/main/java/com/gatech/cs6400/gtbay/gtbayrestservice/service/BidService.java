package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.BidDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Bid;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    private final BidDao bidDao;

    public BidService(@Qualifier("bidDao") BidDao bidDao) {
        this.bidDao = bidDao;
    }

    public void createBid(Bid bid) {
        this.bidDao.createBid(bid);
    }

    public List<Bid> getBidsByItemId(int id) {
        return this.bidDao.getBidsByItemId(id);
    }

}
