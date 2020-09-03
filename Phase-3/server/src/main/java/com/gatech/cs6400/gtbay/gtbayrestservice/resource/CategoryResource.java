package com.gatech.cs6400.gtbay.gtbayrestservice.resource;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Category;
import com.gatech.cs6400.gtbay.gtbayrestservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryResource {

    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            path = "/categories",
            method = RequestMethod.GET)
    public List<String> getCategories() {
        ArrayList<String> res = new ArrayList<>();
        for (Category c: categoryService.getCategories()) res.add(c.getCategory());
        return res;
    }
}
