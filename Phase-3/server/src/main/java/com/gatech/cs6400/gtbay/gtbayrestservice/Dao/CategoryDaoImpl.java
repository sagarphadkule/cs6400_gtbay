package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    @Autowired JdbcTemplate jdbcTemplate;
    @Override
    public ArrayList<Category> getCategories() {
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM Category;");
        ArrayList<Category> categories = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            categories.add(new Category((String)row.get("category")));
        }
        return categories;

    }
}
