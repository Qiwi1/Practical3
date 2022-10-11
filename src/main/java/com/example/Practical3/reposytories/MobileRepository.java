package com.example.Practical3.reposytories;

import com.example.Practical3.models.Mobile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobileRepository extends CrudRepository<Mobile, Long> {

        List<Mobile> findByModelsTel(String title);

        }