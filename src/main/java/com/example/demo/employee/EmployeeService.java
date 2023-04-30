package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Optional<Employee> getEmployeeByMail(String mail){

        return employeeRepository.findEmployeeByEmail(mail);
    }

    public void addNewEmployee(Employee employee) throws IllegalAccessException {
        if(employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()){
            throw new IllegalAccessException("Email taken");
        }
        else  employeeRepository.save(employee);
    }

    public  void deleteEmployee(long empId) throws IllegalArgumentException {
        if(employeeRepository.findById(empId).isEmpty()){
            throw new IllegalArgumentException("Employee does not exists!");
        } else employeeRepository.deleteById(empId);

    }

    @Transactional
    public void updateEmployee(long empID, String firstName, String email) throws IllegalAccessException {
        Employee employee=employeeRepository.findById(empID).orElseThrow(()->new IllegalArgumentException("Emp With id "+
                empID +" Does Not Exists"));
        if(firstName!=null&&
                firstName.length()>0&&!Objects.equals(employee.getFirst_name(),firstName)){
            employee.setFirst_name(firstName);
            employeeRepository.save(employee);

        }
        if (email!=null&&
                email.length()>0&&!Objects.equals(employee.getEmail(),email)){
            Optional<Employee>employeeOptional=employeeRepository.findEmployeeByEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalAccessException("Email already has another employee");
            }
            else employee.setEmail(email);
            employeeRepository.save(employee);

        }

    }
}
