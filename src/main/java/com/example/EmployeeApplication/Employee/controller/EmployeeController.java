package com.example.EmployeeApplication.Employee.controller;

import com.example.EmployeeApplication.Employee.service.EmployeeService;
import com.example.EmployeeApplication.Employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @RequestMapping ("/employees")
    @GetMapping ("/employees")
    public List<Employee> finfAllEmployees(){
        return employeeService.getAllEmployees();
    }

//    @RequestMapping ("/employees/{id}")
    @GetMapping ("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

//    @RequestMapping (value = "/employees", method = RequestMethod.POST)
    @PostMapping ("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping ("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody  Employee employee){
        employeeService.updateEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping ("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }
}
