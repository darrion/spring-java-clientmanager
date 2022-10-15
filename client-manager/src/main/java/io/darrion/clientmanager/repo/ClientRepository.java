package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.table.ClientTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class ClientRepository implements CrudRepository<ClientTable, Integer> {
    @Override
    public <S extends ClientTable> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientTable> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ClientTable> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<ClientTable> findAll() {
        return null;
    }

    @Override
    public Iterable<ClientTable> findAllById(Iterable<Integer> integers) {
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
    public void delete(ClientTable entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClientTable> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
