package com.gatech.cs6400.gtbay.mapper;

import com.gatech.cs6400.gtbay.models.domain.ItemDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ItemMapper implements RowMapper<ItemDTO> {

    public ItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemDTO item = new ItemDTO();
        item.setId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setStartingBidPrice(rs.getBigDecimal("starting_bid_price"));
        item.setMinimumSalePrice(rs.getBigDecimal("min_sale_price"));
        item.setGetItNowPrice(rs.getBigDecimal("get_it_now_price"));
        item.setFinalSalePrice(rs.getBigDecimal("final_sale_price"));
        item.setAuctionLength(rs.getInt("auction_length"));
        item.setAuctionEndTime(rs.getTimestamp("auction_end_time"));
        item.setReturnable(rs.getBoolean("returnable"));
        item.setListedByUser(rs.getString("listed_by_user"));
        item.setWinner(rs.getString("winner"));
        item.setCategory(rs.getString("category"));
        item.setCondition(rs.getString("item_condition"));

        return item;
    }
}
