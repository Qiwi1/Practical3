package com.example.Practical3.controllers;


import com.example.Practical3.models.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogControllerMain {
    @GetMapping("/")
    public String FruitMain1(Model model)
    {
        return "main";
    }
}
