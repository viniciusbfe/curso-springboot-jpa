package com.vinibf.cursospring.resources;

import com.vinibf.cursospring.entities.Category;
import com.vinibf.cursospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category findByid(@PathVariable int id){
        return categoryService.findByID(id);
    }
}
