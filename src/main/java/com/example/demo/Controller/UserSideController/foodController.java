package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.State;
import com.example.demo.Services.foodService;
import com.example.demo.Services.stateService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user/food")
public class foodController {

    @Autowired
    private foodService service;

    @Autowired
    private stateService stateService;

    public foodController(foodService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<Food> foods = service.getAll();
        model.addAttribute("foods", foods);
        model.addAttribute("state", "India");
        return "users/food/index";

    }

    @GetMapping("/{state_id}")
    public String findAllFoodByStateId(@PathVariable int state_id,Model model){ 
        List<Food> foods = service.findByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("foods", foods);
        model.addAttribute("state", theState.getName());
        return "users/food/index";
    }
}
