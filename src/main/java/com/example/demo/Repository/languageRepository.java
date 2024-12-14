package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Languages;
import com.example.demo.Entity.State;

@Repository
public interface languageRepository extends JpaRepository<Languages, Integer> {
    @Query("select l from Languages l where stateId=:state_id")
    public List<Languages> findByStateId(@Param("state_id") State state);
}
