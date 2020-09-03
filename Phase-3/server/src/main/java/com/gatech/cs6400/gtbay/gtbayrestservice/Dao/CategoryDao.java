package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.Category;

import java.util.ArrayList;

public interface CategoryDao {
    public abstract ArrayList<Category> getCategories();
}
