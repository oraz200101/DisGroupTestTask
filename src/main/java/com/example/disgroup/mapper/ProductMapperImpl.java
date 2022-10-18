package com.example.disgroup.mapper;

import com.example.disgroup.dto.ProductDto;
import com.example.disgroup.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class ProductMapperImpl implements ProductMapper{
    @Override
    public ProductDto fromProduct(Product product) {
       if(product==null){
        return null;
       }
       ProductDto productDto=new ProductDto();
       productDto.setId(product.getId());
       productDto.setName(product.getName());
       productDto.setDescription(product.getDescription());
       productDto.setImplCost(product.getImplCost());
       return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if(productDto==null){
        return null;
        }
        Product product=new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImplCost(productDto.getImplCost());
        return product;
    }

    @Override
    public List<ProductDto> productDtoList(List<Product> products) {
        if(products==null) {
            return null;
        }
        List<ProductDto> list = new ArrayList<>(products.size());
        products.forEach(product -> list.add(fromProduct(product)));
        return list;
    }
    @Override
    public Page<ProductDto> productDtoPage(Pageable pageable, Page<Product> products) {
        List<ProductDto> list = productDtoList(products.getContent());
        return new PageImpl<>(list, pageable, products.getTotalElements());
    }
}
