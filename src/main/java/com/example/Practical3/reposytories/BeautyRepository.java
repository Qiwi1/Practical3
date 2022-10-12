package com.example.Practical3.reposytories;

import com.example.Practical3.models.Beauty;
import com.example.Practical3.models.Clothes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeautyRepository extends CrudRepository<Beauty, Long> {

    List<Beauty> findByNazvanie(String nazvanie);

}