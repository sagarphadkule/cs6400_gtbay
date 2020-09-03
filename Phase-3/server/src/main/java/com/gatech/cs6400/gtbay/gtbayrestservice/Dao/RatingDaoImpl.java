package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Repository("ratingDao")
public class RatingDaoImpl implements  RatingDao {

    @Autowired JdbcTemplate jdbcTemplate;

    @Override
    public void createRating(Rating rating) {
        jdbcTemplate.update("INSERT INTO Rating(ratedItemId, ratedByUser, comment, stars, timestamp)" +
                                    "VALUES(?,?,?,?,?)", rating.getRatedItemId(), rating.getRatedByUser(),
                                    rating.getComment(), rating.getStars(), rating.getTimestamp());
    }

    @Override
    public ArrayList<Rating> getRatingsByRatedItemId(int ratedItemId) {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(
//                String.format("SELECT * FROM Rating WHERE ratedItemId = '%d'", ratedItemId));
                String.format("SELECT ratedItemID, name, ratedByUser, stars, comment, timestamp, " +
                        "(SELECT AVG(stars) FROM Rating WHERE ratedItemId = %d) as avgStar " +
                        "FROM Rating JOIN Item ON Rating.ratedItemId = Item.id " +
                        "WHERE ratedItemId = %d ORDER BY timestamp DESC", ratedItemId, ratedItemId));
        System.out.println(String.format("SELECT Item.name, ratedItemID, ratedByUser, stars, comment, timestamp, " +
                        "(SELECT AVG(stars) FROM Rating WHERE ratedItemId = %d) as avgStar " +
                        "FROM Rating JOIN Item ON Rating.ratedItemId = Item.id " +
                        "WHERE ratedItemId = %d ORDER BY timestamp DESC", ratedItemId, ratedItemId));
        ArrayList<Rating> ratings = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            Rating rating = new Rating();
            rating.setItemName((String)row.get("name"));
            rating.setRatedByUser((String)row.get("ratedByUser"));
            rating.setComment((String)row.get("comment"));
            rating.setRatedItemId((int)((long)row.get("ratedItemId")));
            rating.setStars((int)(row.get("stars")));
            rating.setTimestamp((Timestamp)row.get("timestamp"));
            rating.setAvgStars(((BigDecimal)row.get("avgStar")).doubleValue());
            ratings.add(rating);
        }
        return ratings;
    }

    @Override
    public void deleteRating(int ratedItemId, String ratedByUser) {
        jdbcTemplate.update(String.format("DELETE FROM Rating WHERE ratedItemId = '%d' AND ratedByUser = '%s'",
                ratedItemId, ratedByUser));
    }

    @Override
    public int getNumberOfRatingByItemIdAndUsername(int itemId, String username) {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(
                String.format("select count(*) as count from rating " +
                        "where ratedByUser = '%s' and ratedItemId = %d;", username, itemId));
        ArrayList<Integer> res = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            res.add(((int)((long)row.get("count"))));
        }
        return res.get(0);
    }


}
