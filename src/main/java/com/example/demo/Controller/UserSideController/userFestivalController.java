package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.FestivalCel;
import com.example.demo.Entity.State;
import com.example.demo.Services.festivalService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/festival")
public class userFestivalController {
    @Autowired
    private festivalService service;

    @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllFestivalByStateId(@PathVariable int state_id, Model model) {
        List<FestivalCel> fests = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("festivals", fests);
        model.addAttribute("state", theState.getName());
        return "users/festival/index";
    }

    public userFestivalController(festivalService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String getAllFestival(Model model) {
        List<FestivalCel> festivals = service.getAllFestivalCel();
        model.addAttribute("festivals", festivals);
        model.addAttribute("state", "India");
        return "users/festival/index";

    }
}
