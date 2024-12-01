/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kikitech.inventoryservice.model.repository;

import com.kikitech.inventoryservice.model.Inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ryanf
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
   

   List<Inventory> findBySkuCodeIn(List<String> skuCode);
    
    
}
