package com.csy.datacrawler.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.csy.datacrawler.adapters.ProductServiceAdapter;
import com.csy.datacrawler.entities.Product;
import com.csy.datacrawler.entities.ProductResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@Tag(name = "Product API", description = "API to call product application's service")
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceAdapter productServiceAdapter;

    @Autowired
    public ProductController(ProductServiceAdapter productServiceAdapter) {
        this.productServiceAdapter = productServiceAdapter;
    }

    @GetMapping
    @Operation(summary = "Retrieve all products", description = "Returns a list of all products")
    public ResponseEntity<ProductResponse> getAllProducts() {
        ProductResponse productResponse = productServiceAdapter.getAllProducts();
        return ResponseEntity.ok(productResponse);
    }
}
