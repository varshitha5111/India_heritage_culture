package com.example.demo.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.State;
import com.example.demo.Repository.stateRepository;

@Service
public class stateService {
    
    @Autowired
    private stateRepository stateRepo;

    public stateService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public List<State> getAllStates(){
        return stateRepo.findAll();
    }

    public void saveState(State theState){
        stateRepo.save(theState);
    }

    public State findById(int id){
        return stateRepo.findById(id).get();
    }

    public void remove(int id){
        stateRepo.deleteById(id);
    }
}
