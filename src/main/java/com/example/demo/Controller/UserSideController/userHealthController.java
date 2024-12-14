package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Entity.Health;
import com.example.demo.Entity.State;
import com.example.demo.Services.healthService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/health")
public class userHealthController {
    @Autowired
    private healthService service;

    public userHealthController(healthService service) {
        this.service = service;
    }

     @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllHealthByStateId(@PathVariable int state_id,Model model){ 
        List<Health> health = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("health", health);
        model.addAttribute("state", theState.getName());
        return "users/health/index";
    }

    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<Health> health = service.getAllHealth();
        model.addAttribute("health", health);
        model.addAttribute("state", "India");
        return "users/health/index";

    }
}
