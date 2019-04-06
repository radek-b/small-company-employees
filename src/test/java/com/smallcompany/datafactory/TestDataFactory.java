package com.smallcompany.datafactory;

import com.smallcompany.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {

    public List<Employee> build6EmployeesData() {
        Employee jamieCEO = new Employee(150, "Jamie", null);
        Employee alan = new Employee(100, "Alan", jamieCEO.getId());
        Employee steve = new Employee(400, "Steve", jamieCEO.getId());
        Employee martin = new Employee(220, "Martin", alan.getId());
        Employee alex = new Employee(275, "Alex", alan.getId());
        Employee david = new Employee(190, "David", steve.getId());

        List<Employee> employees = new ArrayList<>();
        employees.add(jamieCEO);
        employees.add(alan);
        employees.add(steve);
        employees.add(martin);
        employees.add(alex);
        employees.add(david);

        return employees;
    }

    public List<Employee> buildEmployeesDataWithOnlyCEO() {
        Employee jamieCEO = new Employee(150, "Jamie", null);
        List<Employee> employees = new ArrayList<>();
        employees.add(jamieCEO);
        return employees;
    }

    public List<Employee> buildEmployeesDataWith2CEOs() {
        Employee jamieCEO = new Employee(150, "Jamie", null);
        Employee alanCEO = new Employee(100, "Alan", null);
        Employee steve = new Employee(400, "Steve", jamieCEO.getId());

        List<Employee> employees = new ArrayList<>();
        employees.add(jamieCEO);
        employees.add(alanCEO);
        employees.add(steve);

        return employees;
    }

}
