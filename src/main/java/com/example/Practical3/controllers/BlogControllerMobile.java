package com.example.Practical3.controllers;


import com.example.Practical3.models.Mobile;
import com.example.Practical3.reposytories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mobile")
@PreAuthorize("hasAnyAuthority('USER')")
public class BlogControllerMobile {

    @Autowired
    private MobileRepository mobileRepository;

    @GetMapping("/main")
    public String blogMain(Model model)
    {
        Iterable<Mobile> posts = mobileRepository.findAll();

        model.addAttribute("mobile", posts);
        return "mobile-main";
    }

    @GetMapping("/add")
    public String MobileAdd(Mobile mobile, Model model)
    {
        return "mobile-add";
    }

    @PostMapping("/add")
    public String MobilePostAdd(@Valid Mobile mobile, BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors()){
            return "mobile-add";
        }
        mobileRepository.save(mobile);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String mobileFilter(Model model)
    {
        return "mobile-filter";
    }

    @PostMapping("/filter/result")
    public String mobileResult(@RequestParam String modelsTel, Model model)
    {
        List<Mobile> result = mobileRepository.findByModelsTel(modelsTel);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "mobile-filter";
    }

    @GetMapping("/{id}")
    public String mobileDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Mobile> mobile = mobileRepository.findById(id);
        ArrayList<Mobile> res = new ArrayList<>();
        mobile.ifPresent(res::add);
        model.addAttribute("mobile", res);
        if(!mobileRepository.existsById(id))
        {
            return "redirect:/mobile";
        }
        return "mobile-details";
    }

    @GetMapping("/{id}/edit")
    public String mobileEdit(@PathVariable(value = "id") long id, Model model, Mobile mobile)
    {
        if(!mobileRepository.existsById(id))
        {
            return "redirect:/";
        }
//        Optional<Mobile> mobile = mobileRepository.findById(id);
//        ArrayList<Mobile> res = new ArrayList<>();
//        mobile.ifPresent(res::add);
        mobile = mobileRepository.findById(id).orElseThrow();
        model.addAttribute("mobile", mobile);
        return "mobile-edit";
    }

    @PostMapping("/{id}/edit")
    public String mobilePostUpdate (@PathVariable("id")long id, @Valid Mobile mobile,
                                  BindingResult bindingResult,
//                                  @RequestParam String modelsTel,
//                                  @RequestParam String number,
//                                  @RequestParam String memory,
//                                  @RequestParam String memoryGB,
//                                  @RequestParam String operator,
                                  Model model)
    {
        if (bindingResult.hasErrors()){
            return "mobile-edit";
        }
//        Mobile mobile = mobileRepository.findById(id).orElseThrow();
//        mobile.setModelsTel(modelsTel);
//        mobile.setNumber(number);
//        mobile.setMemory(memory);
//        mobile.setMemoryGB(memoryGB);
//        mobile.setOperator(operator);
        mobileRepository.save(mobile);
        return "redirect:/";
    }



    @PostMapping("/{id}/remove")
    public String blogBlogDelete(@PathVariable("id")long id, Model model){
        Mobile post = mobileRepository.findById(id).orElseThrow();
        mobileRepository.delete(post);
        return "redirect:/";
    }
}
