package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.State;

@Repository
public interface stateRepository extends JpaRepository<State,Integer>{
    
}
