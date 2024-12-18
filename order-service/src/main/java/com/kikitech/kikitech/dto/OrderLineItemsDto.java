/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.kikitech.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ryanf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
     private Long id;
      private String skuCode;
      private BigDecimal price;
      private Integer quantity;
}
