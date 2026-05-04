package com.vinibf.cursospring.resources;

import com.vinibf.cursospring.entities.Product;
import com.vinibf.cursospring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product getByID(@PathVariable int id){
        return productService.getByID(id);
    }


}
