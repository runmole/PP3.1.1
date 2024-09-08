package com.example.PP311.controller;

import com.example.PP311.model.User;
import com.example.PP311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(@RequestParam(value = "count", required = false, defaultValue = "50") int count, Model model) {
        model.addAttribute("users", userService.getAllUsers(count));
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam int age) {
        userService.addUser(new User(name, age));
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
