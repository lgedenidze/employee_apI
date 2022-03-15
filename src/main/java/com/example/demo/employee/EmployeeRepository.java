package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends
        JpaRepository<Employee,Long> {

    //select*from employee where email= ?

    Optional<Employee> findEmployeeByEmail(String email);

}
// @Query("Select s from Employee s where s.email=?1")