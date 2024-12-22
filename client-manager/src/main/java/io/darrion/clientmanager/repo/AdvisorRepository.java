package com.example.clientmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.ClientEntity;

@Repository
public interface AdvisorRepository extends CrudRepository<AdvisorEntity, Integer> {
    
    @Query(value = "SELECT count(a) > 0 FROM Advisors a WHERE a.email=?1 ", nativeQuery = true)
    Boolean existsByEmail(String email);

    @Query(nativeQuery = true)
    AdvisorEntity findByEmail(String email); 
}