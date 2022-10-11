package com.example.Practical3.controllers;

import com.example.Practical3.models.Documents;
import com.example.Practical3.models.Person;
import com.example.Practical3.reposytories.DocumentRepository;
import com.example.Practical3.reposytories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PersonController {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/person")
    public String Main(Model model){
        Iterable<Documents> documents = documentRepository.findAll();
        ArrayList<Documents> documentsArrayList = new ArrayList<>();
        for (Documents docs:
                documents) {
            if (docs.getOwner() == null) {
                documentsArrayList.add(docs);
            }
        }

        model.addAttribute("documents", documentsArrayList);
        return "person-add";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String SNILS,
                              Model model)
    {
        Documents documents = documentRepository.findBySNILS(SNILS);
        Person person = new Person(firstname, lastname, documents);
        personRepository.save(person);
        return "redirect:/person";
    }
}
