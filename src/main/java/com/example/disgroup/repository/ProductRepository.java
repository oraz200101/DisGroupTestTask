package com.example.disgroup.repository;

import com.example.disgroup.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT p from Product p order by p.name")
     List<Product> sortByName();

    @Query(value = "SELECT p from Product  p order by p.implCost asc ")
    List<Product> sortByCostAsc();

    @Query(value = "SELECT p from Product  p order by p.implCost desc ")
    List<Product> sortByCostDesc();

}
