package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class CustomerReturn {

    @Id
    private Long customerReturnId;
    private LocalDate returnDate;
    private Integer quantity;
    private String reason;

    public CustomerReturn() {
    }

    public Long getCustomerReturnId() {
        return customerReturnId;
    }

    public void setCustomerReturnId(Long customerReturnId) {
        this.customerReturnId = customerReturnId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}