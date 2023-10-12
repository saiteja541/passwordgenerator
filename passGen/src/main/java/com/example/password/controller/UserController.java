package com.example.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.password.entity.User;
import com.example.password.repository.UserRepository;

@Controller
@RequestMapping("/") // This is for the root URL
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/") // Mapping for the root URL
    public String getHomePage() {
        // Return the homepage or any other content you want to display on the root URL
        return "homePage";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/create";
    }

    @GetMapping("/create")
    public String getCreateForm() {
        // Return the HTML form
        return "createUserForm";
    }
}
