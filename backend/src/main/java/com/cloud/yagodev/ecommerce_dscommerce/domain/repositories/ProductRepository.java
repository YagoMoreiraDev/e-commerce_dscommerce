package com.cloud.yagodev.ecommerce_dscommerce.domain.repositories;

import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
