package com.mercadona.mercadona.mapper;

import com.mercadona.mercadona.dto.ProductDto;
import com.mercadona.mercadona.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);
}
