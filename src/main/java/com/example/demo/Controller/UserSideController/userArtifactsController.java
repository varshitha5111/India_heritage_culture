package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Artifacts;
import com.example.demo.Entity.State;
import com.example.demo.Services.artifactsService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/artifacts")
public class userArtifactsController {
    @Autowired
    private artifactsService service;

    @Autowired
    private stateService stateService;
    
    public userArtifactsController(artifactsService service) {
        this.service = service;
    }


    @GetMapping("/index")
    public String getAllFestival(Model model) {
        List<Artifacts> artifacts =  service.getAllArtifacts();
        model.addAttribute("artifacts", artifacts);
        model.addAttribute("state", "India");
        return "users/artifacts/index";

    }

    @GetMapping("/{state_id}")
    public String findAllArtifactByStateId(@PathVariable int state_id,Model model){ 
        List<Artifacts> artifacts = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("artifacts",artifacts );
        model.addAttribute("state", theState.getName());
        return "users/artifacts/index";
    }
    
}
