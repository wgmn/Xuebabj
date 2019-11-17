package com.gm.wj.controller;

import com.gm.wj.pojo.User;
import com.gm.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/users")
    public List<User> list() throws Exception {
        return userService.list();
    }
    @PostMapping("/api/user/delete1")
    public void delete(@RequestBody User user) throws Exception {
        System.out.println(user.getId());
        userService.deleteById(user.getId());
    }
    @PostMapping("/users")
    public User addOrUpdate(@RequestBody User user) throws Exception {
        userService.addOrUpdate(user);
        return user;
    }
    @PostMapping("/api/users/change")
    public User addOrUpdate1(@RequestBody User user) throws Exception {
        User au = userService.getById(user);
        au.setPassword(user.getPassword());
        au.setUsername(user.getUsername());
        userService.addOrUpdate(au);
        return au;
    }
}
