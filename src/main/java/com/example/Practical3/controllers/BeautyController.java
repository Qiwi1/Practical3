package com.example.Practical3.controllers;

import com.example.Practical3.models.Beauty;
import com.example.Practical3.reposytories.BeautyRepository;
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
@RequestMapping("/beauty")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class BeautyController {
    @Autowired
    private BeautyRepository beautyRepository;

    @GetMapping("/main")
    public String blogMain(Model model)
    {
        Iterable<Beauty> posts = beautyRepository.findAll();

        model.addAttribute("beauty", posts);
        return "beauty-main";
    }

    @GetMapping("/add")
    public String beautyAdd(Beauty beauty, Model model)
    {
        return "beauty-add";
    }

    @PostMapping("/add")
    public String beautyPostAdd(@Valid Beauty beauty, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()){
            return "beauty-add";
        }
        beautyRepository.save(beauty);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String beautyFilter(Model model)
    {
        return "beauty-filter";
    }

    @PostMapping("/filter/result")
    public String beautyResult(@RequestParam String nazvanie, Model model)
    {
        List<Beauty> result = beautyRepository.findByNazvanie(nazvanie);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "beauty-filter";
    }

    @GetMapping("/{id}")
    public String ClothesDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Beauty> clothes = beautyRepository.findById(id);
        ArrayList<Beauty> res = new ArrayList<>();
        clothes.ifPresent(res::add);
        model.addAttribute("beauty", res);
        if(!beautyRepository.existsById(id))
        {
            return "redirect:/clothes";
        }
        return "beauty-details";
    }

    @GetMapping("/{id}/edit")
    public String beautyEdit(@PathVariable(value = "id") long id, Model model, Beauty beauty)
    {
        if(!beautyRepository.existsById(id))
        {
            return "redirect:/";
        }
        beauty = beautyRepository.findById(id).orElseThrow();
        model.addAttribute("beauty", beauty);
        return "beauty-edit";
    }

    @PostMapping("/{id}/edit")
    public String beautyPostUpdate (@PathVariable("id")long id, @Valid Beauty beauty,
                                     BindingResult bindingResult,
                                     Model model)
    {
        if (bindingResult.hasErrors()){
            return "beauty-edit";
        }
        beautyRepository.save(beauty);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String ClothesDelete(@PathVariable("id")long id, Model model){
        Beauty post = beautyRepository.findById(id).orElseThrow();
        beautyRepository.delete(post);
        return "redirect:/";
    }

}
