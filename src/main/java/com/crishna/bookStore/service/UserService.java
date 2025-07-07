package com.crishna.bookStore.service;

import com.crishna.bookStore.models.User;
import com.crishna.bookStore.repo.UserRepo;
import com.crishna.bookStore.service.base.BaseServiceImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseServiceImp<User, Integer> {

    UserRepo userRepo;

    UserService(JpaRepository<User, Integer> repo) {
        super(repo);
        this.userRepo = (UserRepo) repo;
    }

    public List<User> getByName(String name) {
        return userRepo.getByName(name);
    }

    public List<User> getByAddress(String address) {
        return userRepo.getByAddress(address);
    }
}
