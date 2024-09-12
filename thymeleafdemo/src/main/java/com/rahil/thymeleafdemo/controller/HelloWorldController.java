package com.rahil.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the form.
    @RequestMapping("/processForm")
    public String processFrom(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model
    // @RequestMapping("/processFormVersionTwo")
    // public String lestsShoultDude(HttpServletRequest request, Model model) {

    // // read the request parameter from the HTML form
    // String theName = request.getParameter("studentName");

    // // convert the data to all caps (process the data)
    // // create the message
    // String result = "Yo!" + theName.toUpperCase();

    // // add message to the model
    // model.addAttribute("message", result);

    // return "helloworld";
    // }
    @PostMapping("/processFormVersionTwo")
    public String lestsShoultDude(@RequestParam("studentName") String theName, Model model) {

        String result = "Yo! " + theName.toUpperCase();

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
