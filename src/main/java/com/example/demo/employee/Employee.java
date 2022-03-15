package com.example.demo.employee;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table

public class Employee {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", initialValue = 206, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name = "id", nullable = false)


    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private double salary;
    private LocalDate hire_date;

    public Employee(Long id, String first_name, String last_name, String email, double salary, LocalDate hire_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salary = salary;
        this.hire_date = hire_date;
    }

    public Employee(String first_name, String last_name, String email, double salary, LocalDate hire_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salary = salary;
        this.hire_date = hire_date;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", hire_date=" + hire_date +
                '}';
    }
}

