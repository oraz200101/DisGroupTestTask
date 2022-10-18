package com.example.disgroup.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleDto {
    @Schema(
            description = "Article id",
            example = "1",
            required = true
    )
    private Long id;
    @Schema(
            description = "Article's product"
    )
    private ProductDto product;
    @Schema(
            description = "Article name",
            example = "Article for java"
    )
    private String name;
    @Schema(
            description = "Article content",
            example = "Article for java etc"
    )
    private String content;
    @Schema(
            description = "Article date created"
    )
    private LocalDateTime created;
}
