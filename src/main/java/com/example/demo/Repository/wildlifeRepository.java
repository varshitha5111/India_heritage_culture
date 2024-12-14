package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.Entity.State;
import com.example.demo.Entity.WildLife;

@Repository
public interface wildlifeRepository extends JpaRepository<WildLife, Integer> {
    @Query("select a from WildLife a where stateId=:state_id")
    public List<WildLife> findByStateId(@Param("state_id") State state);
}
