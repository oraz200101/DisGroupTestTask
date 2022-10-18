package com.example.disgroup.service;

import com.example.disgroup.dto.ProductDto;
import com.example.disgroup.entities.Product;

import java.util.List;

public interface ProductService {
    ProductDto getById(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    List<ProductDto> getAll();
    List<ProductDto> sortByName();
    List<ProductDto> sortByCostAsc();
    List<ProductDto> sortByCostDesc();
    void deleteById(Long id);

}
