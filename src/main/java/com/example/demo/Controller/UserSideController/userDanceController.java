package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Dance;
import com.example.demo.Entity.State;
import com.example.demo.Services.danceService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/dance")
public class userDanceController {
    @Autowired
    private danceService service;

    public userDanceController(danceService service) {
        this.service = service;
    }

    @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllDanceByStateId(@PathVariable int state_id,Model model){ 
        List<Dance> dances = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("dances", dances);
        model.addAttribute("state", theState.getName());
        return "users/dance/index";
    }


    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<Dance> dances = service.getAllDances();
        model.addAttribute("dances", dances);
        model.addAttribute("state", "India");
        return "users/dance/index";

    }

    

}
