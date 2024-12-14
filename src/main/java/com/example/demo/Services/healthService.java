package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Health;
import com.example.demo.Entity.State;
import com.example.demo.Repository.healthRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class healthService {
    @Autowired
    private healthRepository healthRepo;

    public healthService(healthRepository healthRepo) {
        this.healthRepo = healthRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public healthService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public healthService(){}

    public List<Health> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return healthRepo.findByStateId(theState.get());
    }


    public void saveChanges(Health health) {
        healthRepo.save(health);
    }

    public List<Health> getAllHealth() {
        return healthRepo.findAll();
    }

    public Health getById(int id) {
        return healthRepo.findById(id).get();
    }

    public void remove(int id) {
        healthRepo.deleteById(id);
    }

}
