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

import com.example.demo.Entity.Artifacts;
import com.example.demo.Services.artifactsService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/artifacts")
public class artifactsController {
    public artifactsController() {

    }

    @Autowired
    private artifactsService service;

    public artifactsController(artifactsService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public artifactsController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("artifacts", service.getAllArtifacts());
        return "admin/artifacts/allArtifacts";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        Artifacts theArtifacts = new Artifacts();
        model.addAttribute("artifact", theArtifacts);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/artifacts/process/add");
        return "admin/artifacts/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addArtifactsForm(@ModelAttribute("artifacts") Artifacts theArtifacts) {
        processImageLists(theArtifacts);
        service.saveChanges(theArtifacts);
        return "redirect:/admin/artifacts";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        Artifacts theArtifacts = service.getById(id);
        model.addAttribute("artifact", theArtifacts);
        model.addAttribute("actionPath", "/admin/artifacts/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/artifacts/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("artifacts") Artifacts theArtifacts) {
        processImageLists(theArtifacts);
        service.saveChanges(theArtifacts);
        ;
        return "redirect:/admin/artifacts";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteArtifactsForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/artifacts";
    }

    public void processImageLists(Artifacts theArtifacts){
        List<String> imageList = theArtifacts.getImageList()!=null?theArtifacts.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theArtifacts.setImages(images);
        }
    }

}
