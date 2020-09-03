package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.RatingDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Rating;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Service
public class RatingService {

    private final RatingDao ratingDao;

    public RatingService(@Qualifier("ratingDao") RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    public void createRating(Rating rating) {
        rating.setTimestamp(new Timestamp(System.currentTimeMillis())); // set current time.
        this.ratingDao.createRating(rating);
    }

    public ArrayList<Rating> getRatingsByRatedItemId(int id) {
        return this.ratingDao.getRatingsByRatedItemId(id);
    }

    public void deleteRating(int ratedItemId, String ratedByUser) {
        this.ratingDao.deleteRating(ratedItemId, ratedByUser);
    }

    public int getNumerOfRatingByItemIdAndUsername(int itemId, String username) {
        return this.ratingDao.getNumberOfRatingByItemIdAndUsername(itemId, username);
    }
}
