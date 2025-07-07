package com.crishna.bookStore.controller.base;

import com.crishna.bookStore.service.base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:
 * Notes -->
 *
 *
 * */

public class BaseControllerImp<T, ID> {

    BaseService<T, ID> baseService;

    public BaseControllerImp(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/add")
    public ResponseEntity<T> addEntity(@RequestBody T entity){
        System.out.println(entity);
        return ResponseEntity.ok((T) baseService.addEntity(entity));
    }

    @PostMapping("/add/all")
    public ResponseEntity<String> addEntities(@RequestBody List<T> entities){
        return ResponseEntity.ok(baseService.addAllEntities(entities));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable ID id){
        return ResponseEntity.ok(baseService.deleteById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<T>> getAll(){
        return ResponseEntity.ok(baseService.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id){
        return ResponseEntity.ok(baseService.getById(id));
    }
}
