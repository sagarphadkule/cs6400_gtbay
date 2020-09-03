package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.CategoryReport;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.UserReport;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportResource {

    @Autowired
    ReportService reportService;

    @RequestMapping(
        path = "/categoryReport",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryReport> generateCategoryReport() {
        return reportService.generateCategoryReport();
    }

    @RequestMapping(
        path = "/userReport",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserReport> generateUserReport() {
        return reportService.generateUserReport();
    }

}
