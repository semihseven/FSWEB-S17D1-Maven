package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> findAll(){
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public void save(@RequestBody Animal animal) {
        animals.put(animal.getId(),animal);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Animal animal) {
        animals.put(id,animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        animals.remove(id);
    }


}


