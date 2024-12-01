package com.kikitech.apigateway;



import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
public class ApigatewayApplication {
    public static void main(String[] args) {SpringApplication.run(ApigatewayApplication.class, args);
    }
}