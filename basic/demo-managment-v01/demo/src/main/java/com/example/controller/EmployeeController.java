package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/manag/api/v1")
public class EmployeeController {

    private static final Log log = LogFactory.getLog(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @RequestMapping("/all")
    public List<Employee> getAllEmployees() {
        log.info(String.format("Searching all employees"));
        return employeeService.fetchAllEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody @Valid Employee updateEntity) {
        log.info(String.format("Update Employee with id %s",id));
        return employeeService.updateById(id, updateEntity);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody @Valid Employee employeeNew) {
        // https://www.baeldung.com/java-split-string-map

        log.info(String.format("Creating Employee: %s",e));
        return employeeService.save(employeeNew);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@RequestParam Long id) {
        return employeeService.getById(id);
    }
    
    @GetMapping("/fistname/{param}")
    public List<Employee> getEmployeesByFirstName(@PathVariable("param") Predicate<? super Employee> param) {
        //Instant start = Instant.now();

        List<Employee> allEmployees = entityManager.createQuery("select e from Employee e", Employee.class)
            .getResultList();
        Stream<Employee> allEmployeesStream = allEmployees.stream();
        for (java.util.function.Predicate<Employee> predicate : predicate) {
            allEmployeesStream = allEmployeesStream.filter(param);
        }

        return allEmployeesStream.collect(Collectors.toList());
    }

}
