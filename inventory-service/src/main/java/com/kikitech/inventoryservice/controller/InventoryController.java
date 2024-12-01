/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.inventoryservice.controller;

import com.kikitech.inventoryservice.dto.InventoryResponse;
import com.kikitech.inventoryservice.service.InventoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor 
public class InventoryController {
    
    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
   public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        
        return inventoryService.isInStock(skuCode);
    }
    
    
}
