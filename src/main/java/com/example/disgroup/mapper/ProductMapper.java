package com.example.disgroup.mapper;

import com.example.disgroup.dto.ProductDto;
import com.example.disgroup.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductMapper {
    ProductDto fromProduct(Product product);
    Product toProduct(ProductDto productDto);
    List<ProductDto> productDtoList(List<Product> products);
    Page<ProductDto> productDtoPage(Pageable pageable, Page<Product> products);

}
