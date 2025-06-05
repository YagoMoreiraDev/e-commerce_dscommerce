package com.cloud.yagodev.ecommerce_dscommerce.domain.controllers;

import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductRequestDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.ProductResponseDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> buscarPorId(@PathVariable Long id) {
        ProductResponseDTO dto = service.buscarPorId(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> buscarTodos(Pageable pageable) {
        Page<ProductResponseDTO> productResponseDtoList = service.buscarTodos(pageable);

        return ResponseEntity.ok(productResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> criarNovo(@RequestBody ProductRequestDTO productRequestDTO) {
        var responseDTO = service.criarNovoProduto(productRequestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(responseDTO.id())
                .toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> atualizaProduto(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO) {
        var responseDTO = service.atualizarProduto(id, requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
