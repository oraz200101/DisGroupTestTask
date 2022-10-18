package com.example.disgroup.repository;

import com.example.disgroup.entities.Article;
import com.example.disgroup.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT a from Article a order by a.name")
    List<Article> sortByName();
    @Query(value = "SELECT a from Article a order by a.created desc ")
    List<Article> sortByCreated();

}
