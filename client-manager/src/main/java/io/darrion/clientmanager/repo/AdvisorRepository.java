package io.darrion.clientmanager.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.AdvisorEntity;

import java.util.Optional;

@Repository
public interface AdvisorRepository extends CrudRepository<AdvisorEntity, Integer> {}