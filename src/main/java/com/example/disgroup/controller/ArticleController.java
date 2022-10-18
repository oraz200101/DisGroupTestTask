package com.example.disgroup.controller;

import com.example.disgroup.dto.ArticleDto;
import com.example.disgroup.entities.Article;
import com.example.disgroup.service.ArticleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@Tag(name = "Article",description = "The Article Api")
public class ArticleController {
//    Swagger Api Doc
//    http://localhost:8080/swagger-ui/index.html#/
    private ArticleServiceImpl articleService;
    @Autowired
    public void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
    @Operation(
            summary = "Find Article by id",
            description = "Find article",
            tags = "Article"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the articles",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Article.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content),
            @ApiResponse(responseCode = "404", description = "article not found", content = @Content)
    })
    @GetMapping(path = "/{id}/")
    public ArticleDto getById(@PathVariable Long id) {
        return articleService.getById(id);
    }
    @PostMapping(consumes = "application/json",path = "/productId/{productId}",produces = "application/json")
    public ArticleDto save(@RequestBody ArticleDto articleDto,@PathVariable Long productId) {
        return articleService.save(articleDto,productId);
    }
    @PutMapping(consumes = "application/json",produces = "application/json")
    public ArticleDto update(@RequestBody ArticleDto articleDto) {
        return articleService.update(articleDto);
    }

    @Operation(
            summary = "Find all articles",
            description = "Find all articles",
            tags = "Article"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the articles",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Article.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content),
            @ApiResponse(responseCode = "404", description = "articles not found", content = @Content)
    })
    @GetMapping(path = "/all/", produces = "application/json")
    public List<ArticleDto> getAll() {
        return articleService.getAll();
    }
    @GetMapping(path = "/all/sortByName",produces = "application/json")
    public List<ArticleDto> sortByName() {
        return articleService.sortByName();
    }
    @GetMapping(path = "/all/sortByCreated",produces = "application/json")
    public List<ArticleDto> sortByCreated() {
        return articleService.sortByCreated();
    }
    @DeleteMapping(path = "/{id}/")
    public void deleteById(@PathVariable Long id) {
        articleService.deleteById(id);
    }
}
