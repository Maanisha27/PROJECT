package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    
    @Query("SELECT p FROM Product p WHERE p.Category.name = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);
    
    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    List<Product> findByProductName(@Param("productName") String productName);

}