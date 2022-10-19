package io.darrion.clientmanager.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
    @Query(value = "SELECT count(*) > 0 FROM clients c WHERE c.email=?1 ", nativeQuery = true)
    Boolean existsByEmail(String email);
}
