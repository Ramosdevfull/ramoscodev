package com.ramoscode.demojwtv01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ramoscode.demojwtv01.model.User;


public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByUsername(String username);
}