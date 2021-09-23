package com.example.emsidi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    
    @GetMapping("/admin")
    private String home() {
        return "home";
    }
}
