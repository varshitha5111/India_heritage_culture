package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Health;
import com.example.demo.Entity.State;

@Repository
public interface healthRepository extends JpaRepository<Health, Integer> {

    @Query("select h from Health h where stateId=:state_id")
    public List<Health> findByStateId(@Param("state_id") State state);
}
