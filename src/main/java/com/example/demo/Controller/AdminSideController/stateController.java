package com.example.demo.Controller.AdminSideController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.State;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/admin/state")
public class stateController {
   public stateController(){

    }
    @Autowired
    private stateService service;

    public stateController(stateService service){
        this.service=service;
    }

    // get all foods
    @GetMapping
    public String index(Model model){ 
        model.addAttribute("states", service.getAllStates());       
        return "admin/state/allStates";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model){
        State theState = new State();
        model.addAttribute("state",theState);
        model.addAttribute("actionPath", "/admin/state/process/add");
        return "admin/state/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addMusicForm(@ModelAttribute("state") State theState){
        service.saveState(theState);
        return "redirect:/admin/state";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model,@PathVariable int id){
        State theState = service.findById(id);
        model.addAttribute("state",theState);
        model.addAttribute("actionPath", "/admin/state/process/update/"+id);
        return "admin/state/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateMusicChanges(@PathVariable int id,@ModelAttribute("state") State theState){
        theState.setId(id);
        service.saveState(theState);;
        return "redirect:/admin/state";
    }

    //delete food
    @GetMapping("/delete/{id}")
    public String deleteDanceForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/state";
    }

}
