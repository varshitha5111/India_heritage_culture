package com.example.demo.Controller.UserSideController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Music;
import com.example.demo.Entity.State;
import com.example.demo.Services.musicService;
import com.example.demo.Services.stateService;

@Controller
@RequestMapping("/user/music")
public class userMusicController {
    @Autowired
    private musicService service;

    public userMusicController(musicService service) {
        this.service = service;
    }

     @Autowired
    private stateService stateService;

    @GetMapping("/{state_id}")
    public String findAllMusicByStateId(@PathVariable int state_id,Model model){ 
        List<Music> musics = service.findAllByStateId(state_id);
        State theState = stateService.findById(state_id);
        model.addAttribute("musics", musics);
        model.addAttribute("state", theState.getName());
        return "users/music/index";
    }

    @GetMapping("/index")
    public String getAllFood(Model model) {
        List<Music> musics = service.getAllMusic();
        model.addAttribute("musics", musics);
        model.addAttribute("state", "India");
        return "users/music/index";

    }

}
