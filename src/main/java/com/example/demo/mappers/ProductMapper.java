package com.example.demo.mappers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toModel(ProductDto productDto);
    ProductDto toDTO(ProductEntity productEntity);

    List<ProductDto> listProductDto(List<ProductEntity> products);

    void updateEntityFromDto(ProductDto productDto, @MappingTarget ProductEntity productEntity);
}
