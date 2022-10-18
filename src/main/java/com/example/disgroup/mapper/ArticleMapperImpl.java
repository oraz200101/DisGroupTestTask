package com.example.disgroup.mapper;

import com.example.disgroup.dto.ArticleDto;
import com.example.disgroup.entities.Article;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class ArticleMapperImpl implements ArticleMapper{
    private  ProductMapperImpl productMapper;
    @Autowired
    public void setProductMapper(ProductMapperImpl productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ArticleDto fromArticle(Article article) {
        if(article==null){
            return null;
        }
        ArticleDto articleDto=new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setName(article.getName());
        articleDto.setContent(article.getContent());
        articleDto.setCreated(article.getCreated());
        if(article.getProduct()==null){
            articleDto.setProduct(null);
        }
        articleDto.setProduct(productMapper.fromProduct(article.getProduct()));
        return articleDto;
    }

    @Override
    public Article toArticle(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article=new Article();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setContent(articleDto.getContent());
        article.setCreated(articleDto.getCreated());
        return article;
    }
    @Override
    public List<ArticleDto> articleDtoList(List<Article> articles) {
        if (articles == null) {
            return null;
        }
        List<ArticleDto>list=new ArrayList<>(articles.size());
        articles.forEach(article -> list.add(fromArticle(article)));
        return list;
    }
}
