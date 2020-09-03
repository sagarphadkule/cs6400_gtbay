package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Item;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchCriteria;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao{

    @Autowired JdbcTemplate jdbcTemplate ;

    @Override
    public void createItem(Item item) {

        String insertItemSql = "INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice," +
                " auctionLength, auctionEndTime, returnable, listedByUser, category, itemCondition) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

        jdbcTemplate.update(insertItemSql, item.getName(), item.getDescription(), item.getStartingBidPrice(),
                item.getMinSalePrice(), item.getGetItNowPrice(), item.getAuctionLength(),
                item.getAuctionEndTime(), item.isReturnable(), item.getListedByUser(), item.getCategory(),
                item.getItemCondition());
    }

    @Override
    public Item getItemById(int id) {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(
                String.format("SELECT * FROM Item JOIN ItemCondition " +
                        "ON Item.itemCondition = ItemCondition.conditionValue WHERE id = '%d'", id));
        List<Item> items = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            Item item = new Item();
            item.setReturnable((boolean)row.get("returnable"));
            item.setCategory((String)row.get("category"));
            item.setDescription((String)row.get("description"));
            item.setName((String)row.get("name"));
            item.setAuctionEndTime((Timestamp)row.get("auctionEndTime"));
            item.setAuctionLength((int)row.get("auctionLength"));
            if (row.get("finalSalePrice") != null) {
                item.setFinalSalePrice(((BigDecimal)row.get("finalSalePrice")).doubleValue());
            }

            if (row.get("getItNowPrice") != null) {
                item.setGetItNowPrice(((BigDecimal) row.get("getItNowPrice")).doubleValue());
            }
            item.setId((int)((long)row.get("id")));
            item.setItemCondition((int)(row.get("itemCondition")));
            item.setCondition((String)(row.get("conditionName")));
            item.setListedByUser((String)row.get("listedByUser"));
            item.setMinSalePrice(((BigDecimal)row.get("minSalePrice")).doubleValue());
            item.setWinner((String)row.get("winner"));
            item.setStartingBidPrice(((BigDecimal)row.get("startingBidPrice")).doubleValue());
            items.add(item);
        }
        return items.get(0);
    }

    @Override
    public ArrayList<ItemSearchResult> search(ItemSearchCriteria criteria) {
        String searchSql =
                "select Item.id as 'ID', Item.name as 'Item Name', res1.currentBid as 'Current Bid', " +
                        "res1.highestBidder as 'High Bidder', Item.getItNowPrice as 'Get It Now Price', " +
                        "Item.auctionEndTime as 'Auction Ends', Item.itemCondition " +
                "from Item left join " +
                    "(select bid.bidItemId as 'itemId', maxBid as 'currentBid', bidByUser as 'highestBidder' " +
                        "from (bid join (select bidItemId, max(amount) as maxBid from bid group by bidItemId)res)" +
                        "where amount = maxBid) res1 " +
                        "on item.id = res1.itemId where Item.auctionEndTime > now() ";

        if (!criteria.getKeyword().equals(" ")) {
            searchSql += "and (Item.name like '%" + criteria.getKeyword() + "%'" +
                    "or Item.description like '%" + criteria.getKeyword() + "%')";
        }

        if (!criteria.getCategory().equals(" ")) {
            searchSql += String.format("and Item.category = '%s' ", criteria.getCategory());
        }
        if (criteria.getMinPrice() >= 0) {
            searchSql += String.format("and (res1.currentBid >= %f " +
                            "or (res1.currentBid is NULL and Item.startingBidPrice >= %f)) ",
                    criteria.getMinPrice(), criteria.getMinPrice());
        }

        if (criteria.getMaxPrice() >= 0) {
            searchSql += String.format("and (res1.currentBid <= %f " +
                            "or (res1.currentBid is NULL and Item.startingBidPrice <= %f)) ",
                    criteria.getMaxPrice(), criteria.getMaxPrice());
        }

        if (criteria.getConditionAtLeast() >= 0) {
            searchSql += String.format("and Item.itemCondition >= %d ", criteria.getConditionAtLeast());
        }

        searchSql += "order by Item.auctionEndTime asc;";

//        System.out.println(searchSql);

        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(searchSql);
        ArrayList<ItemSearchResult> results = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            ItemSearchResult result = new ItemSearchResult();
            result.setId((int)(long)row.get("ID"));
            result.setName((String)row.get("Item Name"));
            result.setCurrentBid(
                    row.get("Current Bid") == null? null: ((BigDecimal)row.get("Current Bid")).doubleValue());
            result.setGetItNowPrice(
                    row.get("Get It Now Price") == null? null: ((BigDecimal)row.get("Get It Now Price")).doubleValue());
            result.setHighBidder((String)row.get("High Bidder"));
            result.setAuctionEnds((Timestamp)row.get("Auction Ends"));
            results.add(result);
        }
        return results;
    }

    @Override
    public void updateWinnerAndFinalSalePrice(String winner, double finalSalePrice, int id) {
        jdbcTemplate.update(String.format("UPDATE Item SET auctionEndTime = now(), winner = '%s', " +
                "finalSalePrice = %f WHERE id = %d;", winner, finalSalePrice, id));
    }

    @Override
    public void updateDescription(String description, int id) {
        jdbcTemplate.update(String.format("UPDATE Item SET description = '%s' " +
            "WHERE id = %d;", description, id));
    }
}
