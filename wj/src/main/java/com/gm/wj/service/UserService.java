package com.gm.wj.service;

import com.gm.wj.dao.UserDAO;
import com.gm.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByUserName(username);
        return null!=user;
    }

    public User getByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    public List<User> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return userDAO.findAll(sort);
    }
    public void addOrUpdate(User user) {
        userDAO.save(user);
    }
    public User getById(User user){
        User u=userDAO.findById(user.getId());
        return u;
    }
}
