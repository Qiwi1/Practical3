package com.example.Practical3.reposytories;

import com.example.Practical3.models.JobPost;
import org.springframework.data.repository.CrudRepository;

public interface JobPostRepository extends CrudRepository<JobPost, Long> {
    JobPost findByName(String name);
}
