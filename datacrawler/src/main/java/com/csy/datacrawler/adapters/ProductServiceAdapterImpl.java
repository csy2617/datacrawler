package com.csy.datacrawler.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.csy.datacrawler.entities.Product;
import com.csy.datacrawler.entities.ProductResponse;

@Component
public class ProductServiceAdapterImpl implements ProductServiceAdapter {

    private final WebClient webClient;

    public ProductServiceAdapterImpl(WebClient.Builder webClientBuilder, 
                                     @Value("${product.service.url}") String baseUrl) {
        this.webClient = webClientBuilder
                            .baseUrl(baseUrl)
                            .build();
    }
    
    @Override
    public ProductResponse getAllProducts() {
        return webClient.get()
            .uri("/api/products")
            .retrieve()
            .bodyToMono(ProductResponse.class)  // Expecting a list of Product objects
            .block();                   // Blocking for simplicity
    }

}

