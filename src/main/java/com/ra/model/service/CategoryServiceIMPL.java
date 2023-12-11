package com.ra.model.service;

import com.ra.model.entity.Category;
import com.ra.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceIMPL implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository ;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.saveOrUpdate(category);
    }

    @Override
    public Boolean delete(Integer id) {
        return categoryRepository.delete(id);
    }
}
