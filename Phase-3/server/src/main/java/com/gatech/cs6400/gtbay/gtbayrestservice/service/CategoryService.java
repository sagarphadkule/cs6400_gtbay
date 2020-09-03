package com.gatech.cs6400.gtbay.gtbayrestservice.service;

import com.gatech.cs6400.gtbay.gtbayrestservice.Dao.CategoryDao;
import com.gatech.cs6400.gtbay.gtbayrestservice.model.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService(@Qualifier("categoryDao") CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public ArrayList<Category> getCategories() {
        return categoryDao.getCategories();
    }
}
