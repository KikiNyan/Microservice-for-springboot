/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.productservice;

/**
 *
 * @author ryanf
 */

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
@Document(value="product")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor

public class Product {
    @Id //unique identifier of product
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    
    
    
    
}
