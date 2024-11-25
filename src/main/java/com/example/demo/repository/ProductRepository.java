package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByName(String name);

    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    @Transactional
    void deleteByName(String name);
}
