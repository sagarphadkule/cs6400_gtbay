package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Rating;

import java.util.ArrayList;

public interface RatingDao {
    abstract void createRating(Rating rating);
    abstract ArrayList<Rating> getRatingsByRatedItemId(int ratedItemId);
    abstract void deleteRating(int ratedItemId, String ratedByUser);
    abstract int getNumberOfRatingByItemIdAndUsername(int itemId, String username);
}
