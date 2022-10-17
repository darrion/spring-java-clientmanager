package io.darrion.clientmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {}
