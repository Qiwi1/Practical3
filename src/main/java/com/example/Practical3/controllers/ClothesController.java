package com.example.Practical3.controllers;


import com.example.Practical3.models.Clothes;
import com.example.Practical3.models.Mobile;
import com.example.Practical3.reposytories.ClothesRepository;
import com.example.Practical3.reposytories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clothes")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class ClothesController {

    @Autowired
    private ClothesRepository clothesRepository;

    @GetMapping("/main")
    public String blogMain(Model model)
    {
        Iterable<Clothes> posts = clothesRepository.findAll();

        model.addAttribute("clothes", posts);
        return "clothes-main";
    }

    @GetMapping("/add")
    public String ClothesAdd(Clothes clothes, Model model)
    {
        return "clothes-add";
    }

    @PostMapping("/add")
    public String ClothesPostAdd(@Valid Clothes clothes, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()){
            return "clothes-add";
        }
        clothesRepository.save(clothes);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String ClothesFilter(Model model)
    {
        return "clothes-filter";
    }

    @PostMapping("/filter/result")
    public String ClothesResult(@RequestParam String nazvanie, Model model)
    {
        List<Clothes> result = clothesRepository.findByNazvanie(nazvanie);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "clothes-filter";
    }

    @GetMapping("/{id}")
    public String ClothesDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Clothes> clothes = clothesRepository.findById(id);
        ArrayList<Clothes> res = new ArrayList<>();
        clothes.ifPresent(res::add);
        model.addAttribute("clothes", res);
        if(!clothesRepository.existsById(id))
        {
            return "redirect:/clothes";
        }
        return "clothes-details";
    }

    @GetMapping("/{id}/edit")
    public String ClothesEdit(@PathVariable(value = "id") long id, Model model, Clothes clothes)
    {
        if(!clothesRepository.existsById(id))
        {
            return "redirect:/";
        }
        clothes = clothesRepository.findById(id).orElseThrow();
        model.addAttribute("clothes", clothes);
        return "clothes-edit";
    }

    @PostMapping("/{id}/edit")
    public String ClothesPostUpdate (@PathVariable("id")long id, @Valid Clothes clothes,
                                    BindingResult bindingResult,
                                    Model model)
    {
        if (bindingResult.hasErrors()){
            return "clothes-edit";
        }
        clothesRepository.save(clothes);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String ClothesDelete(@PathVariable("id")long id, Model model){
        Clothes post = clothesRepository.findById(id).orElseThrow();
        clothesRepository.delete(post);
        return "redirect:/";
    }

}
