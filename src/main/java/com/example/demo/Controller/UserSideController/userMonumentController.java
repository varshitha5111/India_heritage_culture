package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Monuments;
import com.example.demo.Entity.State;
import com.example.demo.Services.monumentService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/monuments")
public class userMonumentController {
    @Autowired
    private monumentService service;

    public userMonumentController(monumentService service) {
        this.service = service;
    }

     @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllMonumentByStateId(@PathVariable int state_id,Model model){ 
        List<Monuments> monuments = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("monuments", monuments);
        model.addAttribute("state", theState.getName());
        return "users/monuments/index";
    }

    @GetMapping("/index")
    public String getAllMonuments(Model model) {
        List<Monuments> monuments = service.getAllMonuments();
        model.addAttribute("monuments", monuments);
        model.addAttribute("state", "India");
        return "users/monuments/index";

    }


}
