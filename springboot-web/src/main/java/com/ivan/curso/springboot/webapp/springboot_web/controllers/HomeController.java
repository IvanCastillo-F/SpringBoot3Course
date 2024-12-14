package com.ivan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    /* Redirect VS Foward 
       Redirect refresh the page and loses all the parameters
       meanwhile the foward doesnt lose these and also doesnt reload the page, and it keeps you in the same url
    
        Foward Example
        @GetMapping({"","/","/home"})
        public String home() {
        return "foward:/list";
        }

    Redirect Example*/
    @GetMapping({"","/","/home"})
    public String home() {
        return "redirect:/list";
    }


    
    
}
