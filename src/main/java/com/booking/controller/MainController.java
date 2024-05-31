package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.entity.UserEntity;
import com.booking.repository.UserRepository;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username, 
                               @RequestParam("password") String password, 
                               Model model) {
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("message", "User already exists!");
            return "register";
        }

        UserEntity newUser = new UserEntity();
        newUser.setUserName(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRole("USER");

        userRepository.save(newUser);

        model.addAttribute("message", "User registered successfully!");
        return "login";
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "logout";
    }
}
