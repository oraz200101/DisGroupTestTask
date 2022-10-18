package com.example.disgroup.service;

import com.example.disgroup.dto.ArticleDto;
import com.example.disgroup.entities.Article;

import java.util.List;

public interface ArticleService {
    ArticleDto getById(Long id);
    ArticleDto save(ArticleDto articleDto,Long productId);
    ArticleDto update(ArticleDto articleDto);
    List<ArticleDto> getAll();
    List<ArticleDto> sortByName();
    List<ArticleDto> sortByCreated();
    void deleteById(Long id);
    Article addArticleToProduct(Long articleId,Long productId);
}
