package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;
  private String productName;
  private String description;
  private Double price;
  private Integer stockQuantity;
  @ManyToOne
  @JoinColumn(name = "category_Id")
  private Category Category;
  public Product() {
  }
  public Product(Long productId, String productName, String description, Double price, Integer stockQuantity,
     Category category) {
    this.productId = productId;
    this.productName = productName;
    this.description = description;
    this.price = price;
    this.stockQuantity = stockQuantity;
    this.Category = category;
  }
  public Long getProductId() {
    return productId;
  }
  public void setProductId(Long productId) {
    this.productId = productId;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public Integer getStockQuantity() {
    return stockQuantity;
  }
  public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
  public Category getCategory() {
    return Category;
  }
  public void setCategory(Category category) {
    this.Category = category;
  }
  
}