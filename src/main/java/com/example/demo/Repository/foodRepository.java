package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.State;

@Repository
public interface foodRepository extends JpaRepository<Food,Integer> {
 
    @Query("select f from Food f where f.state=:state")
    public List<Food> findAllByStateId(@Param("state") State state);
}
