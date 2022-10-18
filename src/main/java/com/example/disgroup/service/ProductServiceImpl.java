package com.example.disgroup.service;

import com.example.disgroup.dto.ProductDto;
import com.example.disgroup.entities.Product;
import com.example.disgroup.mapper.ProductMapperImpl;
import com.example.disgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
   private final ProductRepository productRepository;
   private final ProductMapperImpl productMapper;
    @Autowired(required = false)
    public ProductServiceImpl(ProductRepository productRepository, ProductMapperImpl productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getById(Long id) {
        return productMapper.fromProduct(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid product id")));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.fromProduct(productRepository.save(productMapper.toProduct(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product=productRepository.findById(productDto.getId()).orElseThrow(()->new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImplCost(productDto.getImplCost());
        return productMapper.fromProduct(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAll() {
        return productMapper.productDtoList(productRepository.findAll());
    }

    @Override
    public List<ProductDto> sortByCostAsc() {
        return productMapper.productDtoList(productRepository.sortByCostAsc());
    }

    @Override
    public List<ProductDto> sortByCostDesc() {
        return productMapper.productDtoList(productRepository.sortByCostDesc());
    }

    @Override
    public List<ProductDto> sortByName() {
        return productMapper.productDtoList(productRepository.sortByName());
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
