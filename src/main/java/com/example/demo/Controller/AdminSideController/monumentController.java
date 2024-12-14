package com.example.demo.Controller.AdminSideController;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Monuments;
import com.example.demo.Services.monumentService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/monuments")
public class monumentController {

    // private static final String UPLOAD_DIR = System.getProperty("user.dir") +
    // "/uploads/";

    public monumentController() {

    }

    @Autowired
    private monumentService service;

    public monumentController(monumentService service) {
        this.service = service;
    }

    @Autowired
    private stateService theStateService;

    public monumentController(stateService theStateService) {
        this.theStateService = theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model) {
        model.addAttribute("monuments", service.getAllMonuments());
        return "admin/monuments/allMonuments";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model) {
        Monuments theMonument = new Monuments();
        model.addAttribute("monument", theMonument);
        model.addAttribute("states", theStateService.getAllStates());
        model.addAttribute("actionPath", "/admin/monuments/process/add");
        return "admin/monuments/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addMonuments(@ModelAttribute("monument") Monuments theMonument,
            @RequestParam("file") MultipartFile file) {
        if (file != null) {
            process3DImage(theMonument, file);
        }
        processImageLists(theMonument);
        service.saveChanges(theMonument);
        return "redirect:/admin/monuments";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable int id) {
        Monuments theMonument = service.getById(id);
        model.addAttribute("monument", theMonument);
        model.addAttribute("actionPath", "/admin/monuments/process/update/" + id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/monuments/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateFoodChanges(@PathVariable int id, @ModelAttribute("monument") Monuments theMonument,
            @RequestParam("file") MultipartFile file) {
        if (file != null) {
            process3DImage(theMonument, file);
        }
        processImageLists(theMonument);
        theMonument.setId(id);
        service.saveChanges(theMonument);
        return "redirect:/admin/monuments";
    }

    // delete food
    @GetMapping("/delete/{id}")
    public String deleteMonuments(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/monuments";
    }

    // process and get imagelist
    public void processImageLists(Monuments theMonument) {
        List<String> imageList = theMonument.getImageList() != null ? theMonument.getImageList() : null;
        if (imageList != null) {
            imageList.remove(null);
            imageList.remove("");
            String images = String.join(",", imageList);
            if (!images.isBlank()) {
                theMonument.setImages(images);
            }
        }
    }

    public void process3DImage(Monuments theMonument, MultipartFile file) {
        try {
            // Ensure the upload directory exists
            byte[] bytes = file.getBytes();
            File uploadedFile = new File(System.getProperty("user.dir") + "/src/main/resources/static/uploads/"
                    + file.getOriginalFilename());
            file.transferTo(uploadedFile);
            theMonument.setThreeD_image(file.getOriginalFilename());

            // Log or process other form data

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
