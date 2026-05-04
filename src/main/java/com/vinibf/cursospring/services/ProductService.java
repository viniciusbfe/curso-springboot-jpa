package com.vinibf.cursospring.services;

import com.vinibf.cursospring.entities.Product;
import com.vinibf.cursospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByID(int id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
    }
}
