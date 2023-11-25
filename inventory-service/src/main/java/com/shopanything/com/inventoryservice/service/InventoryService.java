package com.shopanything.com.inventoryservice.service;

import com.shopanything.com.inventoryservice.repositiory.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStocks(String skuCode){
        return inventoryRepository.findBySkuCode().isPresent();
    }
}
