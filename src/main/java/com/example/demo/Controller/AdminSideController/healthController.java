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

import com.example.demo.Entity.Health;
import com.example.demo.Services.healthService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/health")
public class healthController {
    public healthController() {

    }

    @Autowired
    private healthService service;

    public healthController(healthService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public healthController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("healths", service.getAllHealth());
        return "admin/health/allHealth";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        Health theHealth = new Health();
        model.addAttribute("health", theHealth);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/health/process/add");
        return "admin/health/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addHealthForm(@ModelAttribute("health") Health theHealth) {
        processImageLists(theHealth);
        service.saveChanges(theHealth);
        return "redirect:/admin/health";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        Health theHealth = service.getById(id);
        model.addAttribute("health", theHealth);
        model.addAttribute("actionPath", "/admin/health/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/health/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("health") Health theHealth) {
        processImageLists(theHealth);
        theHealth.setId(id);
        service.saveChanges(theHealth);
        ;
        return "redirect:/admin/health";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteHealthForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/health";
    }

    public void processImageLists(Health theHealth){
        List<String> imageList = theHealth.getImageList()!=null?theHealth.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theHealth.setImages(images);
        }
    }

}
