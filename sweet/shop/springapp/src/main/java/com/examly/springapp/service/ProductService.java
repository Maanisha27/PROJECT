package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Product;

public interface ProductService {
    
    List<Product> getProductsByCategoryName(String categoryName);
    
    List<Product> getProductsByName(String productName);

}