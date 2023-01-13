package com.example.EmployeeApplication.Employee.service;

import com.example.EmployeeApplication.Employee.entity.Address;
import com.example.EmployeeApplication.Employee.entity.Employee;
import com.example.EmployeeApplication.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Washington"),
            new Employee(2, "Second Employee", "New York")
    ));

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
//        return employeeList;
        return employeeRepository.findAll(); //for database
    }

    public Employee getEmployee(int id){
//        return employeeList.stream().filter(e -> (e.getId() == id)).findFirst().get();
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        // get a single employee by id from db. optional, if no id, throw error
    }

    //save employee created in postman in database, not in the list
    public void createEmployee (Employee employee){
//        employeeList.add(employee);
        ArrayList<Address> addressArrayList = new ArrayList<>();
        for (Address address : employee.getAddresses()){
            addressArrayList.add((new Address(address.getLine1(),
                    address.getLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getCountry(),
                    employee)));
        }
        employee.setAddresses(addressArrayList);
        employeeRepository.save(employee); //curd repo because we extended EmployeeRepository to JpaRepository and use curd methods
    }


    public void updateEmployee(Employee employee){
//        ArrayList<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp : employeeList){
//            if (emp.getId() == employee.getId()){
//                emp.setName(employee.getName());
//                emp.setCity(employee.getCity());
//            }
//            tempEmployee.add(emp);
//        }
//        this.employeeList = tempEmployee;
        employeeRepository.save(employee); //update employee in database

    }

    public void deleteEmployee(int id){
//        ArrayList<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp: employeeList){
//            if (emp.getId() == id)
//                continue;
//            tempEmployee.add(emp);
//        }
//        this.employeeList = tempEmployee;
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }

}
