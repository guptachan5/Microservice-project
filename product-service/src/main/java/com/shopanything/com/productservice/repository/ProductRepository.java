package com.shopanything.com.productservice.repository;


import com.shopanything.com.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
