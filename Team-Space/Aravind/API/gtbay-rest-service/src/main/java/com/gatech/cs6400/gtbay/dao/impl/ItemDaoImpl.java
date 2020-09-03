package com.gatech.cs6400.gtbay.dao.impl;

import static com.gatech.cs6400.gtbay.constants.Queries.INSERT_ITEM;
import static com.gatech.cs6400.gtbay.constants.Queries.SELECT_ITEM;

import com.gatech.cs6400.gtbay.dao.ItemDao;
import com.gatech.cs6400.gtbay.mapper.ItemMapper;
import com.gatech.cs6400.gtbay.models.domain.ItemDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertItem(ItemDTO item, String username) {
        jdbcTemplate.update(INSERT_ITEM, item.getName(), item.getDescription(), item.getStartingBidPrice(),
            item.getMinimumSalePrice(), item.getGetItNowPrice(), null, item.getAuctionLength(),
            getCurrentDatePlusXDays(item.getAuctionLength()), item.isReturnable(), username, null, item.getCategory(),
            item.getCondition());
    }

    @Override
    public ItemDTO retrieveItem(Integer itemId) {
        return jdbcTemplate.queryForObject(SELECT_ITEM,
            new Object[]{itemId}, new ItemMapper());
    }

    private java.sql.Date getCurrentDatePlusXDays(int x) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, x);
        DateTime dateTime = new DateTime();
        return new java.sql.Date(dateTime.plusDays(x).getMillis());
    }
}
