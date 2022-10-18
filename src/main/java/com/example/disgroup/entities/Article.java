package com.example.disgroup.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Article {
    private static final String SEQ_NAME = "article_seq";
    @Schema(
            description = "Article id",
            example = "1",
            required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Schema(
            description = "Article's product"
    )
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
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
    @CreationTimestamp
    private LocalDateTime created;

}
