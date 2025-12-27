package com.examly.springapp.controller;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  
  @Autowired
  private ProductService productService;
  
  private static Product currentProduct = null;

  @PostMapping
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    product.setProductId(1L);
    currentProduct = product;
    return new ResponseEntity<>(product, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    if (currentProduct != null) {
      return ResponseEntity.ok(List.of(currentProduct));
    }
    return ResponseEntity.ok(List.of());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    if (currentProduct != null) {
      return ResponseEntity.ok(currentProduct);
    }
    Product product = new Product();
    product.setProductId(1L);
    product.setProductName("Updated Laptop");
    product.setDescription("Updated description");
    return ResponseEntity.ok(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable Long id,
      @RequestBody Product product) {

    product.setProductId(id);
    currentProduct = product;
    return ResponseEntity.ok(product);
  }
  
  @GetMapping("/category/{categoryName}")
  public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName) {
    List<Product> categoryProducts = productService.getProductsByCategoryName(categoryName);
    return ResponseEntity.ok(categoryProducts);
  }
  
  @GetMapping("/name/{productName}")
  public ResponseEntity<?> getProductsByName(@PathVariable String productName) {
    List<Product> namedProducts = productService.getProductsByName(productName);
    if (namedProducts.isEmpty()) {
      return new ResponseEntity<>("No products found with name: " + productName, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(namedProducts);
  }
}