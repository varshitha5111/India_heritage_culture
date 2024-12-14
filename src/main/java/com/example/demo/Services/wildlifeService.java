package com.example.demo.Services;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.State;
// import com.example.demo.Entity.Music;
// import com.example.demo.Entity.State;
import com.example.demo.Entity.WildLife;
import com.example.demo.Repository.stateRepository;
// import com.example.demo.Repository.stateRepository;
import com.example.demo.Repository.wildlifeRepository;

@Service
public class wildlifeService {
    @Autowired
    private wildlifeRepository wildlifeRepo;



    public wildlifeService(wildlifeRepository wildlifeRepo) {
        this.wildlifeRepo = wildlifeRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public wildlifeService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public wildlifeService(){}

    public List<WildLife> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return wildlifeRepo.findByStateId(theState.get());
    }

    public void saveChanges(WildLife wildLife) {
        wildlifeRepo.save(wildLife);
    }


    public List<WildLife> getAllWildLife() {
        return wildlifeRepo.findAll();
    }

    public WildLife getById(int id) {
        return wildlifeRepo.findById(id).get();
    }

    public void remove(int id) {
        wildlifeRepo.deleteById(id);
    }

}
