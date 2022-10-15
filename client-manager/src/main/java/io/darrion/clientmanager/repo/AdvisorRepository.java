package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.table.AdvisorTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class AdvisorRepository implements CrudRepository<AdvisorTable, Integer> {
    @Override
    public <S extends AdvisorTable> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AdvisorTable> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AdvisorTable> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<AdvisorTable> findAll() {
        return null;
    }

    @Override
    public Iterable<AdvisorTable> findAllById(Iterable<Integer> integers) {
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
    public void delete(AdvisorTable entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends AdvisorTable> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
