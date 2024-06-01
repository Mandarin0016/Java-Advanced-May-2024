package _02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    // 1. Fields
    private String name;
    private List<Employee> employees;

    // 2. Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getDepartmentSalary() {
        double sum = 0;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public String toString() {

        //Highest Average Salary: {department}
        //{name1} {salary1} {email1} {age1}
        //{name2} {salary2} {email2} {age2}
        //…
        //{namen} {salaryn} {emailn} {agen}
        StringBuilder sb = new StringBuilder();
        sb.append("Highest Average Salary: ").append(this.name).append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
