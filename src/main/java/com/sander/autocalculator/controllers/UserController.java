package com.sander.autocalculator.controllers;

import com.sander.autocalculator.models.User;
import com.sander.autocalculator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String email,
                          @RequestParam String phoneNumber,
                          @RequestParam String password) {
        User user = new User(email, phoneNumber, password);
        userService.save(user);
        return "redirect:/calculator";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return "welcome";
    }

}
