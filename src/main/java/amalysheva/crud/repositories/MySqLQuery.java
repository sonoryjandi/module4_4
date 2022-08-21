package amalysheva.crud.repositories;

import amalysheva.crud.entities.Persistable;

public interface MySqLQuery<T extends Persistable> {
    String insert(T entity);
    String read (int id);
    String updateValue(String field, String newValue, int id);
    String delete(int id);
    String creatTable();
}
