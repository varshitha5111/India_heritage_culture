package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Artifacts;
import com.example.demo.Entity.State;

@Repository
public interface artifactsRepository extends JpaRepository<Artifacts,Integer> {
    
    @Query("select a from Artifacts a where stateId=:state_id")
    public List<Artifacts> findByStateId(@Param("state_id") State state);
    
}
