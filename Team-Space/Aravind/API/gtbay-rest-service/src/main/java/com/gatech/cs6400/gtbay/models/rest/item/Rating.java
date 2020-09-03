package com.gatech.cs6400.gtbay.models.rest.item;

import javax.validation.constraints.NotNull;

public class Rating {
    @NotNull
    private Integer numberOfStars;
    @NotNull
    private String comment;
    @NotNull
    private String ratedBy;

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }
}
