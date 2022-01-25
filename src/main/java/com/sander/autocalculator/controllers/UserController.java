package com.sander.autocalculator.controllers;

import com.sander.autocalculator.models.User;
import com.sander.autocalculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/calculator")
    public String calculator(Model model) {
        return "calculator";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String email,
                          @RequestParam String phoneNumber,
                          @RequestParam String password, Model model) {
        User user = new User(email, phoneNumber, password);
        userRepository.save(user);
        return "redirect:/calculator";
    }
}
