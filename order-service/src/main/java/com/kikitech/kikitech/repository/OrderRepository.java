/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kikitech.kikitech.repository;

import com.kikitech.kikitech.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ryanf
 */
 public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
