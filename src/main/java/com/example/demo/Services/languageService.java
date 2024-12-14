package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Languages;
import com.example.demo.Entity.State;
import com.example.demo.Repository.languageRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class languageService {

    @Autowired
    private languageRepository languageRepo;

    public languageService(languageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }

    @Autowired
    private stateRepository stateRepo;

    public languageService(stateRepository stateRepo){
        this.stateRepo=stateRepo;
    }

    public languageService(){}

    public List<Languages> findAllByStateId(int state_id){
        Optional<State> theState = stateRepo.findById(state_id);
        return languageRepo.findByStateId(theState.get());
    }


    public void saveChanges(Languages languages) {
        languageRepo.save(languages);
    }

    public List<Languages> getAllLanguages() {
        return languageRepo.findAll();
    }

    public Languages getById(int id) {
        return languageRepo.findById(id).get();
    }

    public void remove(int id) {
        languageRepo.deleteById(id);
    }

}
