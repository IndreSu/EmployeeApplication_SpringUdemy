package com.example.EmployeeApplication.Employee.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //this employee needs to be converted into the table
public class Employee {
    @Id //employee id is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generation strategy for employee id, it will generate id automatically (autoincrement)
    private int id;
    private String name;
    private String city;

    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//   cascade all propagates (persiduoti) all the operations from the parent entity to the child entity
    private Spouse spouse;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Address> addresses;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "fk_employee"),
    inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private Set<Project> projects = new HashSet<>( );

    public Employee() {
    }

    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void addAddress(Address address){
        this.addresses = new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address){
        this.addresses.remove(address);
        address.setEmployee(null);
    }
}
