package com.example.Practical3.reposytories;

import com.example.Practical3.models.Fruit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FruitRepository extends CrudRepository<Fruit, Long> {

    List<Fruit> findByNazvanieContains(String nazvanie);
}
