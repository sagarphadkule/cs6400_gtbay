package com.gatech.cs6400.gtbay.gtbayrestservice.constant;

public class Queries {

    public static final String GENERATE_CATEGORY_REPORT = "SELECT *\n"
        + "FROM\n"
        + "   (SELECT \n"
        + "   category AS `Category`, COUNT(id) AS `Total Items`\n"
        + "   FROM Item \n"
        + "   GROUP BY category) RESULT1\n"
        + "LEFT JOIN\n"
        + "   (SELECT \n"
        + "   AVG(getitnowprice) AS `Average Price`,\n"
        + "   MIN(getitnowprice) AS `Min Price`,\n"
        + "MAX(getitnowprice) AS `Max Price`,\n"
        + "category AS `Category`\n"
        + "   FROM Item \n"
        + "   WHERE \n"
        + "   getitnowprice IS NOT NULL \n"
        + "   GROUP BY category) RESULT2\n"
        + "ON RESULT1.Category = RESULT2.Category\n"
        + "ORDER BY RESULT1.category ASC;";

    public static final String GENERATE_USER_REPORT = "Select * from     \n"
        + "(select username as Username from User) Users NATURAL LEFT JOIN\n"
        + "(SELECT listedByUser AS Username, COUNT(listedByUser) AS Listed, COUNT(finalSalePrice) AS Sold FROM Item GROUP BY listedByUser) Purchased NATURAL LEFT JOIN\n"
        + "(SELECT winner AS Username, COUNT(winner) AS Purchased FROM Item WHERE winner IS NOT NULL GROUP BY winner) Winner NATURAL LEFT JOIN\n"
        + "(SELECT ratedByUser AS Username, COUNT(ratedByUser) AS Rated FROM Rating GROUP BY ratedByUser) Ratings  ORDER BY Listed DESC;";

    public static final String LATEST_BIDS = "SELECT amount AS 'Bid Amount'," +
            " timestamp AS 'Time of Bid'," +
            " bidByUser AS 'Username'" +
            " FROM bid WHERE bidItemId = '$item_id'" +
            " ORDER BY timestamp DESC" +
            " LIMIT 4";

    public static final String UPDATE_AUCTION_WINNERS = "" +
            "UPDATE Item mainItem\n" +
            "        INNER JOIN\n" +
            "    (SELECT \n" +
            "        ANS.bid_item, ANS.max_amount, B.bid_by_user AS winner\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        I.item_id AS bid_item, MAX(B.amount) AS max_amount\n" +
            "    FROM\n" +
            "        Item I\n" +
            "    INNER JOIN Bid B ON I.item_id = B.bid_item_id\n" +
            "        AND I.winner IS NULL\n" +
            "        AND I.auction_end_time < NOW()\n" +
            "        AND B.amount >= I.min_sale_price\n" +
            "    GROUP BY I.item_id) ANS, Bid B\n" +
            "    WHERE\n" +
            "        B.bid_item_id = ANS.bid_item\n" +
            "            AND B.amount = ANS.max_amount) ANS2 ON mainItem.item_id = ANS2.bid_item \n" +
            "SET \n" +
            "    mainItem.winner = ANS2.winner,\n" +
            "    mainItem.final_sale_price = ANS2.max_amount\n" +
            "WHERE\n" +
            "    mainItem.item_id = ANS2.bid_item;";

    public static final String FETCH_AUCTION_RESULTS = "" +
            "SELECT  \n" +
            "    id, \n" +
            "    name, \n" +
            "    IFNULL(finalSalePrice, '-') AS finalSalePrice, \n" +
            "    IFNULL(winner, '-') AS winner, \n" +
            "    auctionEndTime\n" +
            "FROM \n" +
            "    Item \n" +
            "WHERE \n" +
            "    Item.auctionEndTime < NOW() \n" +
            "ORDER BY auctionEndTime DESC;";

    public static final String UPDATE_WINNERS_AND_FINAL_SALE_PRICE = "" +
            "UPDATE  \n" +
            "    Item mainItem\n" +
            "INNER JOIN\n" +
            "    (SELECT \n" +
            "        ANS.bidItemId, ANS.max_amount, B.bidByUser AS winner\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "            I.id AS bidItemId, MAX(B.amount) AS max_amount\n" +
            "        FROM\n" +
            "            Item I\n" +
            "        INNER JOIN Bid B ON I.id = B.bidItemId\n" +
            "            AND I.winner IS NULL\n" +
            "            AND I.auctionEndTime < NOW()\n" +
            "            AND B.amount >= I.minSalePrice\n" +
            "        GROUP BY I.id) ANS, Bid B\n" +
            "    WHERE\n" +
            "        B.bidItemId = ANS.bidItemId\n" +
            "    AND B.amount = ANS.max_amount\n" +
            "    ) ANS2 \n" +
            "ON mainItem.id = ANS2.bidItemId \n" +
            "SET \n" +
            "    mainItem.winner = ANS2.winner,\n" +
            "    mainItem.finalSalePrice = ANS2.max_amount\n" +
            "WHERE\n" +
            "    mainItem.id = ANS2.bidItemId;";

}


