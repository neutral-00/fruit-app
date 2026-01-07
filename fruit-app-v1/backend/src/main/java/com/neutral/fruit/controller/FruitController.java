package com.neutral.fruit.controller;

import com.neutral.fruit.domain.Fruit;
import com.neutral.fruit.service.FruitService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }

    @PostMapping
    public ResponseEntity<Fruit> createFruit(@Validated(Default.class) @RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.saveFruit(fruit);
        return ResponseEntity.ok(savedFruit);
    }
}
