package com.example.demo.Products;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path = "api/v1/products")
public class ProductsController {
    private final ProductsService productsService;


    public ProductsController(ProductsService productsService)  {
        this.productsService = productsService;
    }

   // @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public void addProducts(@RequestBody(required = true) Products products) throws IllegalAccessException{
        System.out.println(products);
        productsService.addProducts(products);
    }

    @GetMapping(path = "StorageId")

    public List<Products> getProducts(@RequestParam int storageId){
       return productsService.getProductByStorageId(storageId);
    }
}
