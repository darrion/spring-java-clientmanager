package io.darrion.clientmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.AdvisorEntity;

@Repository
public interface AdvisorRepository extends CrudRepository<AdvisorEntity, Integer> {}