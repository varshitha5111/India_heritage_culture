package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Languages;
import com.example.demo.Entity.State;
import com.example.demo.Services.languageService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/language")
public class userLanguageController {
    @Autowired
    private languageService service;

    
    
    public userLanguageController(languageService service) {
        this.service = service;
    }

     @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllLanguageByStateId(@PathVariable int state_id,Model model){ 
        List<Languages> languages = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("languages", languages);
        model.addAttribute("state", theState.getName());
        return "users/languages/index";
    }

    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<Languages> languages =  service.getAllLanguages();
        model.addAttribute("languages", languages);
        model.addAttribute("state","India");
        return "users/languages/index";

    }


}
