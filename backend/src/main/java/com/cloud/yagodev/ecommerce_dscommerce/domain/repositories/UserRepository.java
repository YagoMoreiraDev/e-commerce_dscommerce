package com.cloud.yagodev.ecommerce_dscommerce.domain.repositories;

import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
