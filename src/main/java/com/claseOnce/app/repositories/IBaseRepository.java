package com.claseOnce.app.repositories;

import java.util.List;

public interface IBaseRepository<E> {

    List<E> findAll();

    E findById(Long id);

    void save(E entity);

    void update(E entity);

    void delete(Long id);
}
