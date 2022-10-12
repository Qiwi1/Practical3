package com.example.Practical3.controllers;


import com.example.Practical3.models.Fruit;
import com.example.Practical3.models.Mobile;
import com.example.Practical3.reposytories.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fruit")
@PreAuthorize("hasAnyAuthority('USER')")
public class    BlogControllerFruit {

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping("/Main")
    public String FruitMain(Model model)
    {
        Iterable<Fruit> posts = fruitRepository.findAll();
        model.addAttribute("Fruit", posts);
        return "fruit-main";
    }

    @GetMapping("/add")
    public String FruitAdd(Fruit fruit, Model model)
    {
        return "fruit-add";
    }

    @PostMapping("/add")
    public String FruitPostAdd(@Valid Fruit fruit, BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors()){
            return "fruit-add";
        }
        fruitRepository.save(fruit);
        return "fruit-main";
    }

    @GetMapping("/filter")
    public String FruitFilter(Model model)
    {
        return "fruit-filter";
    }

    @PostMapping("/filter/result")
    public String FruitResult(@RequestParam String nazvanie, Model model)
    {
        List<Fruit> result = fruitRepository.findByNazvanieContains(nazvanie);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "fruit-filter";
    }

    @GetMapping("/{id}")
    public String FruitDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        ArrayList<Fruit> res = new ArrayList<>();
        fruit.ifPresent(res::add);
        model.addAttribute("Fruit", res);
        if(!fruitRepository.existsById(id))
        {
            return "redirect:/fruit";
        }
        return "fruit-details";
    }

    @GetMapping("/{id}/edit")
    public String FruitEdit(@PathVariable(value = "id") long id, Model model, Fruit fruit)
    {
        if(!fruitRepository.existsById(id))
        {
            return "redirect:/";
        }
//        Optional<Fruit> fruit = fruitRepository.findById(id);
//        ArrayList<Fruit> res = new ArrayList<>();
//        fruit.ifPresent(res::add);
        fruit =fruitRepository.findById(id).orElseThrow();
        model.addAttribute("fruit", fruit);
        return "fruit-edit";
    }

    @PostMapping("/{id}/edit")
    public String FruitPostUpdate (@PathVariable("id")long id, @Valid Fruit fruit,
                                    BindingResult bindingResult,
//                                  @RequestParam String nazvanie,
//                                  @RequestParam String strana,
//                                  @RequestParam String ves,
//                                  @RequestParam String forma,
//                                  @RequestParam String kolwo,
                                  Model model)
    {
        if (bindingResult.hasErrors()){
            return "fruit-edit";
        }
//        Fruit fruit = fruitRepository.findById(id).orElseThrow();
//        fruit.setNazvanie(nazvanie);
//        fruit.setStrana(strana);
//        fruit.setVes(ves);
//        fruit.setForma(forma);
//        fruit.setKolwo(kolwo);
        fruitRepository.save(fruit);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String FruitDelete(@PathVariable("id")long id, Model model){
        Fruit fruit = fruitRepository.findById(id).orElseThrow();
        fruitRepository.delete(fruit);
        return "redirect:/";
    }
}
