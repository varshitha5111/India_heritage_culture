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

import com.example.demo.Entity.Music;
import com.example.demo.Services.musicService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("admin/music")
public class MusicController {
    
    public MusicController(){

    }
    @Autowired
    private musicService service;

    public MusicController(musicService service){
        this.service=service;
    }

    @Autowired
    private stateService theStateService;

    public MusicController(stateService theStateService){
        this.theStateService=theStateService;
    }

    // get all foods
    @GetMapping
    public String index(Model model){ 
        model.addAttribute("musics", service.getAllMusic());       
        return "admin/music/allMusic";
    }

    // add new food
    @GetMapping("/add")
    public String getAddForm(Model model){
        Music theMusic = new Music();
        model.addAttribute("music",theMusic);
        model.addAttribute("states",theStateService.getAllStates() );
        model.addAttribute("actionPath", "/admin/music/process/add");
        return "admin/music/showForm";
    }

    // process add form
    @PostMapping("/process/add")
    public String addMusicForm(@ModelAttribute("music") Music theMusic){
        processImageLists(theMusic);
        service.saveChanges(theMusic);
        return "redirect:/admin/music";
    }

    // get update form of food
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model,@PathVariable int id){
        Music theMusic = service.getById(id);
        model.addAttribute("music",theMusic);
        model.addAttribute("actionPath", "/admin/music/process/update/"+id);
        model.addAttribute("states", theStateService.getAllStates());
        return "admin/music/showForm";
    }

    // process update form of food
    @PostMapping("/process/update/{id}")
    public String updateMusicChanges(@PathVariable int id,@ModelAttribute("music") Music theMusic){
        processImageLists(theMusic);
        theMusic.setId(id);
        service.saveChanges(theMusic);;
        return "redirect:/admin/music";
    }

    //delete food
    @GetMapping("/delete/{id}")
    public String deleteDanceForm(@PathVariable int id) {
        service.remove(id);
        return "redirect:/admin/music";
    }

    public void processImageLists(Music theMusic){
        List<String> imageList = theMusic.getImageList()!=null?theMusic.getImageList():null;
        if(imageList!=null){
        imageList.remove(null);
        imageList.remove("");
        String images = String.join(",", imageList);        
        theMusic.setImages(images);
        }
    }

}
