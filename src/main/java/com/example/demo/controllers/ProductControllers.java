package com.example.demo.controllers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("product")
@RequiredArgsConstructor
public class ProductControllers {
    private final ProductMapper productMapper;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }
}
