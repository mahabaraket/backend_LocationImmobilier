package com.loca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loca.modal.User;

public interface UserDao extends JpaRepository<User, Long> {

}
