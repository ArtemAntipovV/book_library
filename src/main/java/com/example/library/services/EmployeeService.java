package com.example.library.services;


import com.example.library.model.Employee;
import com.example.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Optional<Employee> findByLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
