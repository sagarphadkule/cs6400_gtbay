package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.ItemCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Repository("itemConditionDao")
public class ItemConditionDaoImpl implements ItemConditionDao {

    @Autowired JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<ItemCondition> getItemConditions() {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "SELECT * FROM ItemCondition ORDER BY conditionValue DESC;");
        ArrayList<ItemCondition> itemConditions = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            itemConditions.add(new ItemCondition((String)row.get("conditionName"),
                    (int)(row.get("conditionValue"))));
        }
        return itemConditions;
    }

    @Override
    public int getConditionValueByConditionName(String name) {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(
                String.format("SELECT conditionValue FROM ItemCondition WHERE conditionName = '%s';", name));
        ArrayList<Integer> itemValues = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            itemValues.add((int)(row.get("conditionValue")));
        }
        return itemValues.get(0);
    }
}
