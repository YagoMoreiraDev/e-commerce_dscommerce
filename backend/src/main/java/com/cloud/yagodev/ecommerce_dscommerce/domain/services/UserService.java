package com.cloud.yagodev.ecommerce_dscommerce.domain.services;

import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.UserRequestDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.dtos.UserResponseDTO;
import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.User;
import com.cloud.yagodev.ecommerce_dscommerce.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserResponseDTO buscarPorId(Long id) {
        User user = repository.findById(id).get();
        return new UserResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> buscarTodos() {
        List<User> userList = repository.findAll();

        return userList.stream().map(item -> new UserResponseDTO(item)).toList();
    }

    @Transactional
    public UserResponseDTO criarNovo(UserRequestDTO userRequestDTO) {
        var user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setBirthDate(userRequestDTO.getBirthDate());
        user.setPassword(userRequestDTO.getPassword());

        user = repository.save(user);

        return new UserResponseDTO(user);
    }

}
