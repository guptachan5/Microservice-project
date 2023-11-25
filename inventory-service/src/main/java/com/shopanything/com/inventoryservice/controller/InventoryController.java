package com.shopanything.com.inventoryservice.controller;

import com.shopanything.com.inventoryservice.repositiory.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private InventoryRepository inventoryRepository;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStocks(@PathVariable("sku-code") String skuCode){
        return true;
    }
}
