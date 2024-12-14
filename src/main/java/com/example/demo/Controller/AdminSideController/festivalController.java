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

import com.example.demo.Entity.FestivalCel;
import com.example.demo.Services.festivalService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/festivals")
public class festivalController {

    public festivalController() {

    }

    @Autowired
    private festivalService service;

    public festivalController(festivalService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public festivalController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("festivals", service.getAllFestivalCel());
        return "admin/festivals/allFestivals";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        FestivalCel theFestival = new FestivalCel();
        model.addAttribute("festival", theFestival);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/festivals/process/add");
        return "admin/festivals/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addArtifactsForm(@ModelAttribute("festival") FestivalCel theFestival) {
       processImageLists(theFestival);
        service.saveChanges(theFestival);
        return "redirect:/admin/festivals";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        FestivalCel theFestivalCel = service.getById(id);
        model.addAttribute("festival", theFestivalCel);
        model.addAttribute("actionPath", "/admin/festivals/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/festivals/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("festivals") FestivalCel theFestival) {
        processImageLists(theFestival);
        theFestival.setId(id);
        service.saveChanges(theFestival);
        return "redirect:/admin/festivals";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteArtifactsForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/festivals";
    }

    public void processImageLists(FestivalCel theFestival){
        List<String> imageList = theFestival.getImageList()!=null?theFestival.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theFestival.setImages(images);
        }
    }

}
