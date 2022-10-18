package com.example.disgroup.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    @Schema(
            description = "Product id",
            example = "1",
            required = true
    )
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
