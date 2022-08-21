package amalysheva.crud.repositories;

import amalysheva.crud.entities.Persistable;

public interface Repository<T extends Persistable> {
    void insert(T entity);

    T read(int id);

    T update();

    void delete();
}
