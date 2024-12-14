package com.ivan.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ivan.curso.springboot.webapp.springboot_web.models.User;



@Controller
public class UserController {
    
    @GetMapping("/details")
    public String details(Model model){
        User user =  new User("Ivan", "Castillo");
        user.setEmail("Hello@gmail.com");
        model.addAttribute("title", "Hello World!");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        //model.addAttribute("users", users);
        model.addAttribute("title","List of users");
        return "list";
    }
    
    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
            new User("Pepe", "Castañeda", "pc@gmail.com"), 
            new User("Alex", "Flores", "AF@gmail.com"),
            new User("Andres", "Doe"));
    }
}
