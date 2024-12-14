package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Monuments;
import com.example.demo.Entity.State;

@Repository
public interface monumentsRepository extends JpaRepository<Monuments, Integer> {
    @Query("select m from Monuments m where stateId=:state_id")
    public List<Monuments> findByStateId(@Param("state_id") State state);
}
