package com.ramoscodev.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramoscodev.demoapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
