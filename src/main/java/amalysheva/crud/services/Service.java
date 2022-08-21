package amalysheva.crud.services;

import amalysheva.crud.entities.Persistable;

import java.sql.SQLException;

public interface Service<T extends Persistable> {
    int create(T entity) throws SQLException;

    T read(T entity);

    T update(T entity, String value); //???\

    void delete();
}
