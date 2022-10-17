package io.darrion.clientmanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.darrion.clientmanager.entity.ClientEntity;

import java.util.Optional;

@Repository
public class ClientRepository implements CrudRepository<ClientEntity, Integer> {
    @Override
    public <S extends ClientEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ClientEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<ClientEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<ClientEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ClientEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClientEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
