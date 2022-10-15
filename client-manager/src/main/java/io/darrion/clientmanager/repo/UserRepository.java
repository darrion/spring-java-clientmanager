package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class UserRepository implements CrudRepository<UserModel, Integer> {

    @Override
    public <S extends UserModel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UserModel> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UserModel> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<UserModel> findAll() {
        return null;
    }

    @Override
    public Iterable<UserModel> findAllById(Iterable<Integer> integers) {
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
    public void delete(UserModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserModel> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
