package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.ReportDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.CategoryReport;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.UserReport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    public List<CategoryReport> generateCategoryReport() {
        return reportDao.retrieveCategoryReport();
    }


    public List<UserReport> generateUserReport() {
        return reportDao.retrieveUserReport();
    }
}
