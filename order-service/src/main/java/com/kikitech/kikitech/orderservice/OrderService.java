/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kikitech.kikitech.orderservice;

import brave.Tracer;
import brave.Span;

import com.kikitech.kikitech.Order;
import com.kikitech.kikitech.dto.InventoryResponse;
import com.kikitech.kikitech.dto.OrderLineItemsDto;
import com.kikitech.kikitech.dto.OrderRequest;
import com.kikitech.kikitech.model.OrderLineItems;
import com.kikitech.kikitech.repository.OrderRepository;
import com.kikitech.kikitech.config.WebClientConfig;
import java.util.Arrays;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author ryanf
 */


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional  //this way transactional framework will auto create and acoomit transactions once order is placed
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;



    public String placeOrder(OrderRequest orderRequest){
          WebClient webClient = webClientBuilder.build();

        Order order = new Order();
        order.setOrderNumber (UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

         List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

         log.info("Calling inventory Service");

             //call inventory service and place order if product isi in
             //stock
             InventoryResponse[] inventoryResponseArray = webClient.get()
                     .uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                     .retrieve()
                     .bodyToMono(InventoryResponse[].class)
                     .block(); //synscronoucs communication between services

             boolean allProductsInStock;

             allProductsInStock = Arrays
                     .stream(inventoryResponseArray)
                     .allMatch(InventoryResponse::isInStock);

             if(allProductsInStock){
                 orderRepository.save(order);
                 return "order placed succesfully";
             }else
             {
                 throw new IllegalArgumentException("Product is not in stock, please try again later ");
             }

         }





    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
