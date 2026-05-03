package com.vinibf.cursospring.repositories;

import com.vinibf.cursospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
