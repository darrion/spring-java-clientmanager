package io.darrion.clientmanager.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.ClientEntity;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
    @Query(value = "SELECT count(c) > 0 FROM Clients c WHERE c.email=?1 ", nativeQuery = true)
    Boolean existsByEmail(String email);

    @Query(nativeQuery = true)
    ClientEntity findByEmail(String email);

    @Query(nativeQuery = true)
    List<ClientEntity> findClientsByAdvisorId(Integer advisorId);
}
