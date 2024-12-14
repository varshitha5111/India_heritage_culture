package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.FestivalCel;
import com.example.demo.Entity.State;
import com.example.demo.Repository.festivalRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class festivalService {
    @Autowired
    private festivalRepository festivalRepo;

    public festivalService(festivalRepository festivalRepo) {
        this.festivalRepo = festivalRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public festivalService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public festivalService(){

    }

    public void saveChanges(FestivalCel festival) {
        festivalRepo.save(festival);
    }

    public List<FestivalCel> getAllFestivalCel() {
        return festivalRepo.findAll();
    }

    public FestivalCel getById(int id) {
        return festivalRepo.findById(id).get();
    }

    public void remove(int id) {
        festivalRepo.deleteById(id);
    }

    public List<FestivalCel> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return festivalRepo.findByStateId(theState.get());
    }

}
