package com.example.demo.Controller.UserSideController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorController {
    @GetMapping("/error")
    public String error(){
        return "redirect:/user/index";
    }    
}
