package com.collections.practice;

import java.util.*;

class Employee {
    private int empId;
    private String empName;
    private String emailId;
    private String event;
    public Employee(int empId, String empName, String emailId, String event) {
        this.empId = empId;
        this.empName = empName;
        this.emailId = emailId;
        this.event = event;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    @Override
    public boolean equals(Object obj) {
        Employee otherEmp = (Employee) obj;
        if (this.emailId.equals(otherEmp.emailId))
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        return emailId.hashCode();
    }
    @Override
    public String toString() {
        return "Employee Id: " + empId + ", Employee Name: " + empName + ", Email Id: " + emailId;
    }
}
public class SetAssignment2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(5004, "Wyatt", "Wyatt@example.com","Dance"));
        employees.add(new Employee(5010, "Lucy", "Lucy@example.com","Dance"));
        employees.add(new Employee(5550, "Aaron", "Aaron@example.com","Dance"));
        employees.add(new Employee(5560, "Ruby", "Ruby@example.com","Dance"));
        employees.add(new Employee(5015, "Sophie", "Sophie@example.com","Music"));
        employees.add(new Employee(5013, "Clara", "Clara@example.com","Music"));
        employees.add(new Employee(5010, "Lucy", "Lucy@example.com","Music"));
        employees.add(new Employee(5011, "Ivan", "Ivan@example.com","Music"));
        employees.add(new Employee(5550, "Aaron", "Aaron@example.com","Music"));
        Set<Employee> employeeNominations = findUnique(employees);
        System.out.println("Employees who have submitted nominations");
        for(Employee employee: employeeNominations)
            System.out.println(employee);

        Set<Employee> duplicateEmployees = findDuplicates(employees);
        System.out.println("\nEmployees who have submitted nominations for both the events");
        for(Employee employee: duplicateEmployees)
            System.out.println(employee);
    }
    public static Set<Employee> findUnique(List<Employee> employees) {
        return new HashSet<>(employees);
    }
    public static Set<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> set = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();
        for(Employee employee:employees){
            if(!set.add(employee)){
                duplicates.add(employee);
            }
        }
        return duplicates;
    }
}

