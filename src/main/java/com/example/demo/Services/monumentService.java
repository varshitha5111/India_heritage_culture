package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.Monuments;
import com.example.demo.Entity.State;
import com.example.demo.Repository.monumentsRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class monumentService {
    @Autowired
    private monumentsRepository monumentsRepo;

    public monumentService(monumentsRepository monumentsRepo) {
        this.monumentsRepo = monumentsRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public monumentService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public monumentService(){}

    public List<Monuments> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return monumentsRepo.findByStateId(theState.get());
    }


    public void saveChanges(Monuments monuments) {
        monumentsRepo.save(monuments);
    }

    public List<Monuments> getAllMonuments() {
        return monumentsRepo.findAll();
    }

    public Monuments getById(int id) {
        return monumentsRepo.findById(id).get();
    }

    public void remove(int id) {
        monumentsRepo.deleteById(id);
    }

}
