package com.example.demo.controllers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<List<ProductDto>> getProducts(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

    @PutMapping("/product/{name}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "name") String name, @RequestBody @Valid ProductDto productDto) {
        ProductDto product = productService.updateProduct(name, productDto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/product/{name}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "name") String name) {
        productService.deleteProduct(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
