package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Employee;

public interface EmployeeService {
    
    Employee save(Employee employee);

    java.util.List<Employee> fetchAllEmployees();

    Employee getById(Long id);

    Employee updateById(Long id, Employee employee);

    String deletById(Long id);
    @Query(value = "SELECT e FROM EMPLOYEE e WHERE e.first_name = :firstname")
    List<Employee> findEmployeeByFirstName(@Param("firstname") String nameEmpĺoyee);
}
