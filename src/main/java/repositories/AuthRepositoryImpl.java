package repositories;

import models.Auth;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl implements AuthRepository{

    private final Connection connection;


    public AuthRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        return null;
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Auth save(Auth auth) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
