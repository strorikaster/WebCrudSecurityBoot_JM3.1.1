package com.webcrudsecurityboot.webcrudsecurityboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.webcrudsecurityboot.webcrudsecurityboot.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/lk")
    public String getUserPage(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "show";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        return "show";
    }
}
