package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Artifacts;
import com.example.demo.Entity.State;
import com.example.demo.Repository.artifactsRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class artifactsService {
    @Autowired
    private artifactsRepository artifactsRepo;

    @Autowired
    private stateRepository stateRepo;

    public artifactsService(stateRepository stateRepo) {
        this.stateRepo = stateRepo;
    }

    public artifactsService(artifactsRepository artifactsRepo) {
        this.artifactsRepo = artifactsRepo;
    }

    public artifactsService(){
        
    }

    public void saveChanges(Artifacts artifacts) {
        artifactsRepo.save(artifacts);
    }

    public List<Artifacts> getAllArtifacts() {
        return artifactsRepo.findAll();
    }

    public Artifacts getById(int id) {
        return artifactsRepo.findById(id).get();
    }

    public void remove(int id) {
        artifactsRepo.deleteById(id);
    }

    public List<Artifacts> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return artifactsRepo.findByStateId(theState.get());
    }
}
