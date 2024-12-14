package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.State;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user")
public class userHomeController {

    @Autowired
    private stateService service;

    public userHomeController(stateService service) {
        this.service = service;
    }

    public userHomeController(){

    }

    @GetMapping("/index")
    public String home(Model model){
        List<State> states = service.getAllStates();
        model.addAttribute("states", states);
        return "main";
    }

    @GetMapping("/index/section/{id}")
    public String section(@PathVariable int id,Model model){
        State theState = service.findById(id);
        model.addAttribute("state", theState.getName());
        model.addAttribute("id",id);
        return "sectionPage";
    }

}
