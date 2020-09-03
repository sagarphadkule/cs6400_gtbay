package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Rating;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RatingResource {

    private final RatingService ratingService;

    @Autowired
    public RatingResource(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @RequestMapping(
            path = "/ratings",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRating(@RequestBody Rating rating) {
        this.ratingService.createRating(rating);
    }

    @RequestMapping(
            path = "/ratings/{id}",
            method = RequestMethod.GET)
    public ArrayList<Rating> getRatingsByRatedItemId(@PathVariable("id") int ratedItemId) {
        return this.ratingService.getRatingsByRatedItemId(ratedItemId);
    }

    @RequestMapping(
            path = "/ratings/{ratedItemId}/{ratedByUser}",
            method = RequestMethod.DELETE)
    public void deleteRating(@PathVariable("ratedItemId") int ratedItemId,
                             @PathVariable("ratedByUser") String ratedByUser) {
        this.ratingService.deleteRating(ratedItemId, ratedByUser);
    }

    @RequestMapping(
            path = "/ratings/count/{ratedItemId}/{ratedByUser}",
            method = RequestMethod.GET)
    public int getNumberOfRatingByItemIdAndUsername(
                            @PathVariable("ratedItemId") int ratedItemId,
                             @PathVariable("ratedByUser") String ratedByUser) {
        return this.ratingService.getNumerOfRatingByItemIdAndUsername(ratedItemId, ratedByUser);
    }



}
