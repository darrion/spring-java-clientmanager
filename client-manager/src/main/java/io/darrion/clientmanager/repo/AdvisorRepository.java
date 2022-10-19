package io.darrion.clientmanager.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.AdvisorEntity;

@Repository
public interface AdvisorRepository extends CrudRepository<AdvisorEntity, Integer> {
    @Query(value = "SELECT count(a) > 0 FROM Advisors a WHERE a.email=?1 ", nativeQuery = true)
    Boolean existsByEmail(String email);
}