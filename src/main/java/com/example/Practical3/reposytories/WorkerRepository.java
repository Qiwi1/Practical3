package com.example.Practical3.reposytories;

import com.example.Practical3.models.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByFirstname(String firstname);
}
