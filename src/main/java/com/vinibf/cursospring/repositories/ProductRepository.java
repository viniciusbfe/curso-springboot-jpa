package com.vinibf.cursospring.repositories;

import com.vinibf.cursospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
