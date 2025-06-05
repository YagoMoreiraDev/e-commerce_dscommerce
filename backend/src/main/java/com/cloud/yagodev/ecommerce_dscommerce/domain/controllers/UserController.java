package com.cloud.yagodev.ecommerce_dscommerce.domain.controllers;

import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.UserRequestDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.UserResponseDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<UserResponseDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public UserResponseDTO criarNovo(@RequestBody UserRequestDTO userRequestDTO) {
        return service.criarNovo(userRequestDTO);
    }
}
