package com.example.disgroup.service;

import com.example.disgroup.dto.ArticleDto;
import com.example.disgroup.entities.Article;
import com.example.disgroup.entities.Product;
import com.example.disgroup.mapper.ArticleMapperImpl;
import com.example.disgroup.repository.ArticleRepository;
import com.example.disgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final ProductRepository productRepository;
    private final ArticleMapperImpl articleMapper;
    @Autowired(required = false)
    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapperImpl articleMapper,ProductRepository productRepository) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
        this.productRepository=productRepository;
    }

    @Override
    public ArticleDto getById(Long id) {
        return articleMapper.fromArticle(articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid article id")));
    }

    @Override
    public ArticleDto save(ArticleDto articleDto,Long productId) {
        Article article=articleMapper.toArticle(articleDto);
        articleRepository.save(article);
       return articleMapper.fromArticle(addArticleToProduct(article.getId(),productId));
    }

    @Override
    public Article addArticleToProduct(Long articleId, Long productId) {
        Article article=articleRepository.findById(articleId).orElseThrow(()->new RuntimeException("Invalid article id"));
        Product product=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Invalid product id"));
        article.setProduct(product);
        articleRepository.save(article);
        return article;
    }
    @Override
    public ArticleDto update(ArticleDto articleDto) {
        Article article=articleRepository.findById(articleDto.getId()).orElseThrow(()->new RuntimeException("Invalid article id"));
        article.setName(articleDto.getName());
        article.setContent(articleDto.getContent());
        return articleMapper.fromArticle(articleRepository.save(article));
    }

    @Override
    public List<ArticleDto> getAll() {
        return articleMapper.articleDtoList(articleRepository.findAll());
    }

    @Override
    public List<ArticleDto> sortByName() {
        return articleMapper.articleDtoList(articleRepository.sortByName());
    }

    @Override
    public List<ArticleDto> sortByCreated() {
        return articleMapper.articleDtoList(articleRepository.sortByCreated());
    }

    @Override
    public void deleteById(Long id) {
        Article article=articleRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid article id"));
        articleRepository.delete(article);
    }


}
