package com.ra.model.service;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll() ;
    Category findById(Integer id) ;
    Category saveOrUpdate(Category category) ;
    Boolean delete(Integer id) ;
}
