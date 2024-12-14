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

import com.example.demo.Entity.WildLife;
import com.example.demo.Services.wildlifeService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/wildlifes")
public class wildlifeController {
    public wildlifeController() {

    }

    @Autowired
    private wildlifeService service;

    public wildlifeController(wildlifeService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public wildlifeController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("wildlifes", service.getAllWildLife());
        return "admin/wildlifes/allWildlifes";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        WildLife theWildLife = new WildLife();
        model.addAttribute("wildlife", theWildLife);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/wildlifes/process/add");
        return "admin/wildlifes/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addWildLifeForm(@ModelAttribute("wildlife") WildLife theWildLife) {
       processImageLists(theWildLife);
        service.saveChanges(theWildLife);
        return "redirect:/admin/wildlifes";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        WildLife theWildLife = service.getById(id);
        model.addAttribute("wildlife", theWildLife);
        model.addAttribute("actionPath", "/admin/wildlifes/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/wildlifes/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("wildlife") WildLife theWildLife) {
        processImageLists(theWildLife);
        theWildLife.setId(id);
        service.saveChanges(theWildLife);
        return "redirect:/admin/wildlifes";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteWildLifeForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/wildlifes";
    }

    public void processImageLists(WildLife theWildlife){
        List<String> imageList = theWildlife.getImageList()!=null?theWildlife.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theWildlife.setImages(images);
        }
    }
}
