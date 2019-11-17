package com.gm.wj.dao;

import com.gm.wj.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;

public interface UserDAO extends JpaRepository<User,Integer> {

    User findByUsername( String username);

    User getByUsernameAndPassword(String username,String password);

    User findById(int id);
}
