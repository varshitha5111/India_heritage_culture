package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.FestivalCel;
import com.example.demo.Entity.State;

@Repository
public interface festivalRepository extends JpaRepository<FestivalCel, Integer> {
    // select Festivals By state Id
    @Query("select fest from FestivalCel fest where fest.stateId=:state_id")
    public List<FestivalCel> findByStateId(@Param("state_id") State state);
}
