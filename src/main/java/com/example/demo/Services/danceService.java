package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Dance;
import com.example.demo.Entity.State;
import com.example.demo.Repository.danceRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class danceService {
    @Autowired
    private danceRepository danceRepo;
    public danceService(danceRepository danceRepo){
        this.danceRepo=danceRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public danceService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public danceService(){}

    public List<Dance> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return danceRepo.findByStateId(theState.get());
    }

    public void saveChanges(Dance dance){
        danceRepo.save(dance);
    }

    public List<Dance> getAllDances(){
        return danceRepo.findAll();
    }

    public Dance getById(int id){
        return danceRepo.findById(id).get();
    }

    public void remove(int id){
        danceRepo.deleteById(id);
    }

}
