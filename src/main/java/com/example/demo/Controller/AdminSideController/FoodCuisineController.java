package com.example.demo.Controller.AdminSideController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Entity.Food;
import com.example.demo.Services.foodService;
import com.example.demo.Services.stateService;



@Controller
@RequestMapping("admin")
public class FoodCuisineController {

    public FoodCuisineController(){

    }
    @Autowired
    private foodService service;

    public FoodCuisineController(foodService service){
        this.service=service;
    }

    @Autowired
    private stateService theStateService;

    public FoodCuisineController(stateService theStateService){
        this.theStateService=theStateService;
    }

    // get all foods
    @GetMapping("/foodcuisine")
    public String index(Model model){ 
        model.addAttribute("foods", service.getAll());       
        return "admin/food/foodCuisine";
    }

    // add new food
    @GetMapping("/add/foodCuisine")
    public String getAddForm(Model model){
        Food theFood = new Food();
        model.addAttribute("food",theFood);
        model.addAttribute("states",theStateService.getAllStates() );
        model.addAttribute("actionPath", "/admin/process/add/foodCuisine");
        return "admin/food/showForm";
    }

    // process add form
    @PostMapping("/process/add/foodCuisine")
    public String addFoodChanges(@ModelAttribute("food") Food theFood){
        processImageLists(theFood);
        service.saveFood(theFood);
        return "redirect:/admin/foodcuisine";
    }

    // get update form of food
    @GetMapping("/update/foodCuisine/{id}")
    public String getUpdateForm(Model model,@PathVariable int id){
        Food theFood = service.findById(id);
        model.addAttribute("food",theFood);
        model.addAttribute("actionPath", "/admin/process/update/foodCuisine/"+id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/food/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/foodCuisine/{id}")
    public String updateFoodChanges(@PathVariable int id,@ModelAttribute("food") Food theFood){
        processImageLists(theFood);
        theFood.setId(id);
        service.saveFood(theFood);
        return "redirect:/admin/foodcuisine";
    }

    //delete food
    @GetMapping("/delete/foodcuisine/{id}")
    public String getMethodName(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/foodcuisine";
    }

    public void processImageLists(Food theFood){
        List<String> imageList = theFood.getImageList()!=null?theFood.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theFood.setImage(images);
        }
    }

    
    

}
