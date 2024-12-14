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

import com.example.demo.Entity.Dance;
import com.example.demo.Services.danceService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/dance")
public class DanceController {
    public DanceController(){

    }
    @Autowired
    private danceService service;

    public DanceController(danceService service){
        this.service=service;
    }

    @Autowired
    private stateService theStateService;

    public DanceController(stateService theStateService){
        this.theStateService=theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model){ 
        model.addAttribute("dances", service.getAllDances());       
        return "admin/dance/allDance";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model){
        Dance theDance = new Dance();
        model.addAttribute("dance",theDance);
        model.addAttribute("states",theStateService.getAllStates() );
        model.addAttribute("actionPath", "/admin/dance/process/add");
        return "admin/dance/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addDanceForm(@ModelAttribute("dance") Dance theDance){
        processImageLists(theDance);
        service.saveChanges(theDance);
        return "redirect:/admin/dance";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model,@PathVariable int id){
        Dance theDance = service.getById(id);
        model.addAttribute("dance",theDance);
        model.addAttribute("actionPath", "/admin/dance/process/update/"+id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/dance/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id,@ModelAttribute("dance") Dance theDance){
        processImageLists(theDance);
        service.saveChanges(theDance);;
        return "redirect:/admin/dance";
    }

    //delete food
    @GetMapping("/delete/{id}")
    public String deleteDanceForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/dance";
    }

    public void processImageLists(Dance theDance){
        List<String> imageList = theDance.getImageList()!=null?theDance.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theDance.setImages(images);
        }
    }

}
