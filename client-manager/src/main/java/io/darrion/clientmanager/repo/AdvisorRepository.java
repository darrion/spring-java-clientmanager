package io.darrion.clientmanager.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.darrion.clientmanager.entity.AdvisorEntity;

import java.util.Optional;

public class AdvisorRepository implements CrudRepository<AdvisorEntity, Integer> {

    @Override
    public <S extends AdvisorEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AdvisorEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AdvisorEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<AdvisorEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<AdvisorEntity> findAllById(Iterable<Integer> integers) {
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
    public void delete(AdvisorEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends AdvisorEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
