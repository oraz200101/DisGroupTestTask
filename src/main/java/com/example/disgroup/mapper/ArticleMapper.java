package com.example.disgroup.mapper;

import com.example.disgroup.dto.ArticleDto;
import com.example.disgroup.entities.Article;

import java.util.List;

public interface ArticleMapper {
    ArticleDto fromArticle(Article article);
    Article toArticle(ArticleDto articleDto);
    List<ArticleDto> articleDtoList(List<Article>articles);
}
