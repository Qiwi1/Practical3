package com.example.Practical3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerInfo {

    @GetMapping("/info")
    public String Info(Model model)
    {
        return "info";
    }
}