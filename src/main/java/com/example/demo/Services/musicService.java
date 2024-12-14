package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Music;
import com.example.demo.Entity.State;
import com.example.demo.Repository.MusicRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class musicService {
    
    @Autowired
    private MusicRepository musicRepo;

    public musicService(MusicRepository musicRepo) {
        this.musicRepo = musicRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public musicService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public musicService(){}

    public List<Music> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return musicRepo.findByStateId(theState.get());
    }

    
    public void saveChanges(Music music){
        musicRepo.save(music);
    }

    public List<Music> getAllMusic(){
        return musicRepo.findAll();
    }

    public Music getById(int id){
        return musicRepo.findById(id).get();
    }

    public void remove(int id){
        musicRepo.deleteById(id);
    }
}
