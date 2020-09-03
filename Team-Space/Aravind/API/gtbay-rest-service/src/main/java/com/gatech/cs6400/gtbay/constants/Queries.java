package com.gatech.cs6400.gtbay.constants;

public class Queries {

    public static final String SELECT_ITEM = "select * from Item where item_id = ?;";
    public static final String INSERT_ITEM = "INSERT INTO Item \n"
        + "(name, description, starting_bid_price, min_sale_price, get_it_now_price, \n"
        + "final_sale_price, auction_length, auction_end_time, returnable, listed_by_user,\n"
        + "winner, category, item_condition)\n"
        + "VALUES (?, ?, ?, ?, ?, ?, \n"
        + "?, ?, ?, ?,\n"
        + "?, ?, ?);";

}
