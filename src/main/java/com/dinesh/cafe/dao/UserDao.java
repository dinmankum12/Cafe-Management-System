package com.dinesh.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.cafe.POJO.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
