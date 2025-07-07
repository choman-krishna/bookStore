package com.crishna.bookStore.controller;

import com.crishna.bookStore.controller.base.BaseControllerImp;
import com.crishna.bookStore.models.User;
import com.crishna.bookStore.service.UserService;
import com.crishna.bookStore.service.base.BaseServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:
 * Notes : params, request params
 *
 * */

@RestController
@RequestMapping("/user")
public class UserController extends BaseControllerImp<User, Integer> {

    private final UserService userService;

    public UserController(BaseServiceImp<User, Integer> baseService) {
        super(baseService);
        this.userService = (UserService) baseService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<User>> nameUser(@RequestParam String name){
        return ResponseEntity.ok(userService.getByName(name));
    }

    @GetMapping(params = "address")
    public ResponseEntity<List<User>> addressUser(@RequestParam String address){
        return ResponseEntity.ok(userService.getByAddress(address));
    }


}
