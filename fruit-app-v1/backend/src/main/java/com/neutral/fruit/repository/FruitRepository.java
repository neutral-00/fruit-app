package com.neutral.fruit.repository;

import com.neutral.fruit.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, UUID> {
}
