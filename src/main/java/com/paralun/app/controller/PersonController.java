package com.paralun.app.controller;

import com.paralun.app.model.Person;
import com.paralun.app.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String list(Model model, Pageable pageable) {
        Page<Person> personPage = personRepository.findAll(pageable);
        model.addAttribute("page", personPage);
        model.addAttribute("persons", personPage.getContent());
        return "persons";
    }
}
