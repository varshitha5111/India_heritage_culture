package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Music;
import com.example.demo.Entity.State;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>{
    @Query("select m from Music m where stateId=:state_id")
    public List<Music> findByStateId(@Param("state_id") State state);
}
