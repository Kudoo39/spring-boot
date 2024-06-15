package com.example.presentation;

import com.example.application.product.IProductService;
import com.example.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private IProductService _productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(_productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> createAt(@RequestBody Product product) {
        //should return 201
        return ResponseEntity.ok(_productService.createOne(product));
    }
}
