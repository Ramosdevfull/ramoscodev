package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e FROM EMPLOYEE e WHERE e.first_name = :firstname")
    List<Employee> findEmployeeByFirstName(@Param("firstname") String nameEmpĺoyee);
}
