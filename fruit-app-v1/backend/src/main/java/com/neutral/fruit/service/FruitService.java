package com.neutral.fruit.service;

import com.neutral.fruit.domain.Fruit;
import com.neutral.fruit.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

}
