package com.example.Practical3.reposytories;

import com.example.Practical3.models.Floor;
import org.springframework.data.repository.CrudRepository;

public interface FloorRepository extends CrudRepository<Floor, Long> {
    Floor findByInfo(String info);
}