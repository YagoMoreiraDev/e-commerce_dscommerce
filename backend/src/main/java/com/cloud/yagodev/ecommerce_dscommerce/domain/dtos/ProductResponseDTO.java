package com.cloud.yagodev.ecommerce_dscommerce.domain.dtos;

import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.Product;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl
) {
    //Construtor
    public ProductResponseDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImgUrl()
        );
    }
}
