package com.example.demo.services;

import com.example.demo.dtos.ProductDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto){
        productRepository.findByName(productDto.name()).ifPresent(productEntity -> {
            throw new RuntimeException("Produto ja existe");
        });
        ProductEntity productEntity = productRepository.save(productMapper.toModel(productDto));
        return productMapper.toDTO(productEntity);
    }
}
