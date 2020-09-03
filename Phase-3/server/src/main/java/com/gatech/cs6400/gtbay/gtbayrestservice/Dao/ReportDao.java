package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.CategoryReport;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.UserReport;
import java.util.List;

public interface ReportDao {

    List<CategoryReport> retrieveCategoryReport();

    List<UserReport> retrieveUserReport();
}
