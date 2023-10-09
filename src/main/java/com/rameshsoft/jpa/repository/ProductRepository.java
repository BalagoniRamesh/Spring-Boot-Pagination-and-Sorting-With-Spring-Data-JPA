package com.rameshsoft.jpa.repository;

import com.rameshsoft.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
