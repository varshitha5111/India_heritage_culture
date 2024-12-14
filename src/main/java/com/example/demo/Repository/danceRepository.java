package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Dance;
import com.example.demo.Entity.State;

@Repository
public interface danceRepository  extends JpaRepository<Dance,Integer>{
    @Query("select d from Dance d where d.stateId=:state_id")
    public List<Dance> findByStateId(@Param("state_id") State state);
}
