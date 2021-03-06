package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {


    private final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> getEmployee(){

        return employeeService.getEmployee();

    }

    @PostMapping
    public void registerEmployee(@RequestBody Employee employee) throws IllegalAccessException {

    employeeService.addNewEmployee(employee);

    }

    @DeleteMapping(path = "{empId}")
    public void deleteEmployee(@PathVariable long empId){

    employeeService.deleteEmployee(empId);

    }

    @PutMapping(path = "{empID}")
    public void updateEmployee(@PathVariable("empID") long empID,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String email)
                       throws IllegalAccessException {
    employeeService.updateEmployee(empID,firstName,email);
    }



}
