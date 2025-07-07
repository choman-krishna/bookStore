package com.crishna.bookStore.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseServiceImp<T, ID> implements BaseService<T, ID> {

    JpaRepository<T, ID> repo;
    protected BaseServiceImp(JpaRepository<T, ID> repo){
        this.repo = repo;
    }

    @Override
    public T addEntity(T entity) {
        repo.save(entity);
        return entity;
    }

    @Override
    public String addAllEntities(List<T> entities) {
        repo.saveAll(entities);
        return "All Data Added";
    }

    @Override
    public String deleteById(ID id) {
        repo.deleteById(id);
        return "Deleted";
    }

   @Override
    public List<T> getAll() {
        return repo.findAll();
    }

    @Override
    public T getById(ID id) {
        return repo.findById(id).orElse(null);
    }
}
