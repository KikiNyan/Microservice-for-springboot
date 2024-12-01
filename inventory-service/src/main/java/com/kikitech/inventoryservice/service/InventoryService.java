/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.inventoryservice.service;

import com.kikitech.inventoryservice.dto.InventoryResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kikitech.inventoryservice.model.repository.InventoryRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ryanf
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    
      
    private final InventoryRepository inventoryRepository;
    
    
    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode){

        log.info("Wait started");
        Thread.sleep(10000);
        log.info("wait Ended");

       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();//findbysku method is returning  an optional to check whether object is presentor not
       
       
        
                
        
    }
    
}
