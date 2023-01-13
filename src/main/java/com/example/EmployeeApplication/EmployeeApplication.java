package com.example.EmployeeApplication;

import com.example.EmployeeApplication.Employee.entity.Address;
import com.example.EmployeeApplication.Employee.entity.Employee;
import com.example.EmployeeApplication.Employee.entity.Project;
import com.example.EmployeeApplication.Employee.entity.Spouse;
import com.example.EmployeeApplication.Employee.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initialCreate(EmployeeService employeeService){
//		return(args) ->{
//			Address address1 = new Address("Line1", "Line2", "zipCode1", "City1", "Country1");
//			Project project1 = new Project("Name1", "Client Name1");
//			Spouse spouse1 = new Spouse("Name1", "Mobile1", 30);
//
//			Employee employee = new Employee("Employee1", "City1");
//			employee.addProject(project1);
//			employee.addAddress(address1);
//			employee.setSpouse(spouse1);
//
//			employeeService.createEmployee(employee);
//
//			Employee employee1 = employeeService.getEmployee(1);
//
//			//enabled sql
//		};
//	}
}

