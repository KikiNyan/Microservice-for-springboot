package com.kikitech.inventoryservice;

import com.kikitech.inventoryservice.model.Inventory;
import com.kikitech.inventoryservice.model.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class InventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	} 
        @Bean
        public CommandLineRunner loadData(InventoryRepository inventoryRepository){
            return args ->{
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);
            
             Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13_red");
            inventory1.setQuantity(0);
            
            inventoryRepository.save(inventory);
             inventoryRepository.save(inventory1);
            
            
            
            
            
            };
        }

}
