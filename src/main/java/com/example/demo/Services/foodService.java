package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.State;
import com.example.demo.Repository.foodRepository;
import com.example.demo.Repository.stateRepository;

@Service
public class foodService {
    
    @Autowired
    private foodRepository foodRepo;

    @Autowired
    private stateRepository stateRepo;

    public foodService(stateRepository stateRepo) {
        this.stateRepo = stateRepo;
    }

    public foodService(foodRepository foodRepo){
        this.foodRepo=foodRepo;
    }

    public foodService(){
        
    }

    public void saveFood(Food food){
        foodRepo.save(food);
    }

    public Food findById(int id) {
        return foodRepo.findById(id).get();
    }

    public List<Food> getAll(){
        return foodRepo.findAll();
    }

    public void remove(int id) {
        foodRepo.deleteById(id);
    }

    public List<Food> findByStateId(int state_id){
        State theState = stateRepo.findById(state_id).get();
        return foodRepo.findAllByStateId(theState);
    }

}
