package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService ;

    @GetMapping("/")
    public String home() {
        return "home" ;
    }

    @GetMapping("/category")
    public String getCategory(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list) ;
        return "list-category" ;
    }

    @GetMapping("/add-category")
    public String createCategory(Model model) {
        Category category = new Category() ;
        model.addAttribute("category" , category) ;
        return "add-category" ;
    }

    @PostMapping("/add-category")
    public String postCreateCategory(@ModelAttribute("category") Category category) {
        categoryService.saveOrUpdate(category) ;
        return "redirect:/category" ;
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        if (categoryService.delete(id)) {
            return "redirect:/category" ;
        }
        return "list-category" ;
    }

    @GetMapping("/edit-category/{id}")
    public String editCategory(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id) ;
        model.addAttribute("category", category) ;
        return "edit-category" ;
    }

    @PostMapping("/edit-category")
    public String postEditCategory(@ModelAttribute("category") Category category) {
        categoryService.saveOrUpdate(category) ;
        return "redirect:/category" ;
    }
}
