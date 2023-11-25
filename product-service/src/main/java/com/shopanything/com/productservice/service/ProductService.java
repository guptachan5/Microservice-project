package com.shopanything.com.productservice.service;

import com.shopanything.com.productservice.dto.ProductRequest;
import com.shopanything.com.productservice.dto.ProductResponce;
import com.shopanything.com.productservice.model.Product;
import com.shopanything.com.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product : {} is saved", product.getId());
    }

    public List<ProductResponce> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(this::mapToProduct).toList();
    }

    private ProductResponce mapToProduct(Product product) {
        return ProductResponce.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .price(product.getPrice())
                .build();
    }
}
