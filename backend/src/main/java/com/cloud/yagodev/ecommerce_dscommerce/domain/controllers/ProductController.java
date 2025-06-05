package com.cloud.yagodev.ecommerce_dscommerce.domain.controllers;

import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductRequestDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductResponseDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.Product;
import com.cloud.yagodev.ecommerce_dscommerce.domain.repositories.ProductRepository;
import com.cloud.yagodev.ecommerce_dscommerce.domain.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping("/{id}")
    public ProductResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<ProductResponseDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public ProductResponseDTO criarNovo(@RequestBody ProductRequestDTO productRequestDTO) {
        return service.criarNovoProduto(productRequestDTO);
    }
}
