package com.example.Practical3.reposytories;


import com.example.Practical3.models.Clothes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothesRepository extends CrudRepository<Clothes, Long> {

    List<Clothes> findByNazvanie(String nazvanie);

}
