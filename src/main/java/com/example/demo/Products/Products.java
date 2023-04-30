package com.example.demo.Products;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table

public class Products {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", initialValue = 206, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name = "id", nullable = false)
    private int id;
    private int storageId;
    private String productName;
    private int productCount;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int price;

    public Products(int storageId, String productName, int productCount, LocalDate fromDate, LocalDate toDate, int price) {
        this.storageId = storageId;
        this.productName = productName;
        this.productCount = productCount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
    }

    public Products() {

    }

    public Products(int id, int storageId, String productName, int productCount, LocalDate fromDate, LocalDate toDate, int price) {
        this.id = id;
        this.storageId = storageId;
        this.productName = productName;
        this.productCount = productCount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
