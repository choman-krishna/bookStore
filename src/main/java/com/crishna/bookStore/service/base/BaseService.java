package com.crishna.bookStore.service.base;

import java.util.List;

public interface BaseService<T, ID> {

    public T addEntity(T entity);
    public String addAllEntities(List<T> entities);
    public String deleteById(ID id);

    public List<T> getAll();
    public T getById(ID id);

}
