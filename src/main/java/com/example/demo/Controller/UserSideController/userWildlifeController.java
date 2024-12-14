package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.State;
import com.example.demo.Entity.WildLife;
import com.example.demo.Services.stateService;
import com.example.demo.Services.wildlifeService;

@Controller
@RequestMapping("/user/wildlife")
public class userWildlifeController {
    @Autowired
    private wildlifeService service;

    
    public userWildlifeController(wildlifeService service) {
        this.service = service;
    }

     @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllWildLifeByStateId(@PathVariable int state_id,Model model){ 
        List<WildLife> musics = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("wildlifes", musics);
        model.addAttribute("state", theState.getName());
        return "users/wildlife/index";
    }

    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<WildLife> wildlifes =  service.getAllWildLife();
        model.addAttribute("wildlifes", wildlifes);
        model.addAttribute("state", "India");
        return "users/wildlife/index";

    }
}
