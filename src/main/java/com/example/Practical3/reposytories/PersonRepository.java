package com.example.Practical3.reposytories;

import com.example.Practical3.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
