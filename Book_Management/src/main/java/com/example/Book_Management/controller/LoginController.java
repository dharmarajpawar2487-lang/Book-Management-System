package com.example.Book_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Book_Management.model.User;
import com.example.Book_Management.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        User foundUser = userRepository.findByEmail(email);

        if (foundUser == null) {
            model.addAttribute("error", "Email not registered!");
            return "login";
        }

        if (!foundUser.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid Email or Password!");
            return "login";
        }

        return "redirect:/books";  // ✅ Login success
    }
}
