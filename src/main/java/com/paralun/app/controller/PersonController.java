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

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/persons")
    public String list(Model model, Pageable pageable) {
        Page<Person> personPage = personRepository.findAll(pageable);
        model.addAttribute("page", personPage);
        model.addAttribute("persons", personPage.getContent());
        model.addAttribute("url", "/persons");
        return "persons";
    }

    @GetMapping("/persons2")
    public String list2(Model model, Pageable pageable) {
        Page<Person> personPage = personRepository.findAll(pageable);
        PageWrapper<Person> page = new PageWrapper<>(personPage, "/persons2");
        model.addAttribute("persons", personPage.getContent());
        model.addAttribute("page", page);
        return "persons2";
    }
}
