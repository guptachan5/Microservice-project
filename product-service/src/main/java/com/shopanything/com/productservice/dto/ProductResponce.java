package com.shopanything.com.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponce {
    private String productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
}
