package com.example.Practical3.reposytories;


import com.example.Practical3.models.Documents;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Documents, Long> {
    Documents findBySNILS(String snils);
}
