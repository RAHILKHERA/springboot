package com.rahil.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rahil.thymeleafdemo.model.Student;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteLanguages}")
    private List<String> favoriteLanguages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries", countries);

        theModel.addAttribute("favoriteLanguages", favoriteLanguages);

        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println(theStudent);

        return "student-confirmation";
    }

}
