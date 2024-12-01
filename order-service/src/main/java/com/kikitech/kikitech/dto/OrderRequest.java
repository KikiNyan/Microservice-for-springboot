/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.kikitech.dto;

/**
 *
 * @author ryanf
 */
import com.kikitech.kikitech.dto.OrderLineItemsDto;
import java.util.List;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
      private List<OrderLineItemsDto>orderLineItemsDtoList;
}
