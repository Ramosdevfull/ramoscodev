package com.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()) {
            return optEmployee.get();
        }
        return null;
    }

    @Override
    public Employee updateById(Long id, Employee upEmployee) {
        Optional<Employee> optEmployeeDB = employeeRepository.findById(id);
        if (optEmployeeDB.isPresent()) {
            Employee e = optEmployeeDB.get();
            if (Objects.nonNull(upEmployee.getFirstName()) && !"".equalsIgnoreCase(upEmployee.getFirstName())) {
                e.setFirstName(upEmployee.getFirstName());
            }
            if (Objects.nonNull(upEmployee.getLastName()) && !"".equalsIgnoreCase(upEmployee.getLastName())) {
                e.setLastName(upEmployee.getLastName());
            }

            return employeeRepository.save(e);
        }
        return null;
    }

    @Override
    public String deletById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted sucessfully";
        }
        return "Employee not found!";
    }

    @Override
    public List<Employee> findEmployeeByFirstName(@Param("firstname") String nameEmpĺoyee) {
        return employeeRepository.findEmployeeByFirstName(nameEmpĺoyee);
    }
    
}
