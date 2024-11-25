package com.example.demo.services;

import com.example.demo.dtos.ProductDto;
import com.example.demo.exception.products.ProductsNotFoundException;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto){
        productRepository.findByName(productDto.name()).ifPresent(productEntity -> {
            throw new ProductsNotFoundException("Produto ja existe", HttpStatus.CONFLICT.value());
        });
        ProductEntity productEntity = productRepository.save(productMapper.toModel(productDto));
        return productMapper.toDTO(productEntity);
    }

    public List<ProductDto> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        if(products.isEmpty()) {
            throw new ProductsNotFoundException("Nenhum Produto cadastrado no momento", HttpStatus.CONFLICT.value());
        }
        return productMapper.listProductDto(products);
    }

    public List<ProductDto> findByName(String name) {
        List<ProductEntity> products = productRepository.findByNameContainingIgnoreCase(name);
        if (products.isEmpty()) {
            throw new ProductsNotFoundException("Nenhum Produto encontrado", HttpStatus.NOT_FOUND.value());
        }
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDto updateProduct(String name, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findByName(name).orElseThrow(() -> {
            throw new ProductsNotFoundException("Produto não foi encontrado", HttpStatus.NOT_FOUND.value());
        });
        productMapper.updateEntityFromDto(productDto, productEntity);
        ProductEntity updatedEntity = productRepository.save(productEntity);
        return productMapper.toDTO(updatedEntity);
    }

    public void deleteProduct(String name) {
        productRepository.findByName(name).orElseThrow(() -> {
            throw new ProductsNotFoundException("Produto não foi encontrado", HttpStatus.NOT_FOUND.value());
        });
        productRepository.deleteByName(name);
    }
}
