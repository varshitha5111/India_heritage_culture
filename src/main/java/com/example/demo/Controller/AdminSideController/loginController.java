package com.example.demo.Controller.AdminSideController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    
    @GetMapping("/adminlogin")
    public String showLoginPage() {
        System.out.println("loginnnnnnnnnnnnnnnnnnnnnnn");
        return "admin/authentication/login";
    }
}