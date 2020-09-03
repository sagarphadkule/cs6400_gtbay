package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.CategoryReport;
import com.gatech.cs6400.gtbay.gtbayrestservice.constant.Queries;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.UserReport;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements ReportDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryReport> retrieveCategoryReport() {
        return jdbcTemplate.query(Queries.GENERATE_CATEGORY_REPORT, (resultSet, i) -> {
            CategoryReport categoryReport = new CategoryReport();
            categoryReport.setAveragePrice(resultSet.getBigDecimal("Average Price"));
            categoryReport.setMinPrice(resultSet.getBigDecimal("Min Price"));
            categoryReport.setMaxPrice(resultSet.getBigDecimal("Max Price"));
            categoryReport.setTotalItems(resultSet.getInt("Total Items"));
            categoryReport.setCategory(resultSet.getString("Category"));
            return categoryReport;
        });
    }

    @Override
    public List<UserReport> retrieveUserReport() {
        return jdbcTemplate.query(Queries.GENERATE_USER_REPORT, (resultSet, i) -> {
            UserReport userReport = new UserReport();
            userReport.setListed(resultSet.getInt("Listed"));
            userReport.setSold(resultSet.getInt("Sold"));
            userReport.setPurchased(resultSet.getInt("Purchased"));
            userReport.setRated(resultSet.getInt("Rated"));
            userReport.setUserName(resultSet.getString("Username"));
            return userReport;
        });
    }
}
