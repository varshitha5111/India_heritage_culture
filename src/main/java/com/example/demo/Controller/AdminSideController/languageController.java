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

import com.example.demo.Entity.Languages;
import com.example.demo.Services.languageService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/languages")
public class languageController {
    public languageController() {

    }

    @Autowired
    private languageService service;

    public languageController(languageService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public languageController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("languages", service.getAllLanguages());
        return "admin/languages/allLanguages";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        Languages theLanguage = new Languages();
        model.addAttribute("language", theLanguage);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/languages/process/add");
        return "admin/languages/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addArtifactsForm(@ModelAttribute("language") Languages theLanguage) {
        processImageLists(theLanguage);
        service.saveChanges(theLanguage);
        return "redirect:/admin/languages";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        Languages theLanguages = service.getById(id);
        model.addAttribute("language", theLanguages);
        model.addAttribute("actionPath", "/admin/languages/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/languages/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("language") Languages theLanguage) {
        processImageLists(theLanguage);
        theLanguage.setId(id);
        service.saveChanges(theLanguage);
        return "redirect:/admin/languages";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteArtifactsForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/languages";
    }

    public void processImageLists(Languages theLanguage){
        List<String> imageList = theLanguage.getImageList()!=null?theLanguage.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theLanguage.setImages(images);
        }
    }

}
