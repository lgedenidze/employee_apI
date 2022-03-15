package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository studentRepository) {
        this.employeeRepository = studentRepository;
    }

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();

    }

    public void addNewEmployee(Employee employee) throws IllegalAccessException {
        if(employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()){
            throw new IllegalAccessException("Email taken");
        }
        else  employeeRepository.save(employee);
    }
}
