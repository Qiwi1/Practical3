package com.example.Practical3.reposytories;

import com.example.Practical3.models.Building;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository <Building, Long> {
}
