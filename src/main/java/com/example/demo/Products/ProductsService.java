package com.example.demo.Products;


import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService  {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getProductByStorageId(int storageId){

        return productsRepository.findProductsByStorageId(storageId);
    }

    public void addProducts (Products products){
        productsRepository.save(products);
    }





}
