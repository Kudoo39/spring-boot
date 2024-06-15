package com.example.infrastructure.product;

import com.example.domain.product.IProductRepo;
import com.example.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    @Autowired
    private IProductJpaRepo _productRepo;

    @Override
    public Product createProduct(Product product) {
        return _productRepo.save(product);
    }

    @Override
    public List<Product> listAll() {
        return _productRepo.findAll();
    }
}
