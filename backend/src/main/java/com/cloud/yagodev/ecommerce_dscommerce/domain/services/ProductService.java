package com.cloud.yagodev.ecommerce_dscommerce.domain.services;

import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductRequestDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductResponseDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.Product;
import com.cloud.yagodev.ecommerce_dscommerce.domain.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO buscarPorId(Long id) {
        Product product = repository.findById(id).get();
        return new ProductResponseDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponseDTO> buscarTodos(Pageable pageable) {
        Page<Product> productList = repository.findAll(pageable);
        return productList.map(item -> new ProductResponseDTO(item));
    }

    @Transactional
    public ProductResponseDTO criarNovoProduto(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImgUrl(productRequestDTO.getImgUrl());

        product = repository.save(product);

        return new ProductResponseDTO(product);
    }
}
