package com.example.EmployeeApplication.Employee.repository;

import com.example.EmployeeApplication.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

/*
CRUD

getAllEmployees();
getEmployee(id);
upateEmployee(Employee employee);
deleteEmploye(Employee employee or int id);
 */
}
