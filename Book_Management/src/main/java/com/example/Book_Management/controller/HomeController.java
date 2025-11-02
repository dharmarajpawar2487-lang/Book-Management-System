package com.example.Book_Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Default Home Page (Login redirect)
    @GetMapping("/")
    public String homePage() {
        return "login"; 
    }

    // Dashboard/Home Page after login
    @GetMapping("/home")
    public String defaultPage(Model model) {
        model.addAttribute("message", "Welcome to Book Management System!");
        return "home";
    }
}
