package com.smallcompany.datafactory;

import com.smallcompany.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDataFactory {

    public List<Employee> buildEmployeesData() {
        Employee jamie = new Employee(150, "Jamie", null);
        Employee alan = new Employee(100, "Alan", jamie.getId());
        Employee steve = new Employee(400, "Steve", jamie.getId());
        Employee martin = new Employee(220, "Martin", alan.getId());
        Employee alex = new Employee(275, "Alex", alan.getId());
        Employee david = new Employee(190, "David", steve.getId());

        List<Employee> employees = new ArrayList<>();
        employees.add(jamie);
        employees.add(alan);
        employees.add(steve);
        employees.add(martin);
        employees.add(alex);
        employees.add(david);

        return employees;
    }

}
