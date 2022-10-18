package com.example.disgroup.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    private static final String SEQ_NAME = "products_seq";
    @Schema(
            description = "Product id",
            example = "1",
            required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @Schema(
            description = "Product name",
            example = "Java"
    )
    private String name;
    @Schema(
            description = "Product description",
            example = "Java is programming language"
    )
    private String description;
    @Schema(
            description = "Product implementation cost",
            example = "70000.0"
    )
    private double implCost;
}
