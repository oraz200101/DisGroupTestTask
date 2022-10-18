package com.example.disgroup.controller;

import com.example.disgroup.dto.ProductDto;
import com.example.disgroup.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    //    Swagger Api Doc
//    http://localhost:8080/swagger-ui/index.html#/
    private  ProductServiceImpl productService;
    @Autowired
    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/{id}/",produces = "application/json")
    public ProductDto getById(@PathVariable Long id){
       return productService.getById(id);
    }
    @PostMapping(consumes = "application/json",produces = "application/json")
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }
    @PutMapping(consumes = "application/json",produces = "application/json")
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }
    @GetMapping(path = "/all/",produces = "application/json")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }
    @GetMapping(path = "/all/sortByCostAsc")
    public List<ProductDto> sortByCostAsc() {
        return productService.sortByCostAsc();
    }
    @GetMapping(path = "/all/sortByCostDesc")
    public List<ProductDto> sortByCostDesc() {
        return productService.sortByCostDesc();
    }
    @GetMapping(path = "/all/sortByName")
    public List<ProductDto> sortByName() {
        return productService.sortByName();
    }
    @DeleteMapping(path = "/{id}/")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
