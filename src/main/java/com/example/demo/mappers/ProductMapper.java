package com.example.demo.mappers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toModel(ProductDto productDto);
    ProductDto toDTO(ProductEntity productEntity);
}
