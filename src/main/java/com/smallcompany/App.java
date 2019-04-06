package com.smallcompany;

import com.smallcompany.datafactory.EmployeesDataFactory;
import com.smallcompany.domain.Employee;
import com.smallcompany.printer.HierarchyPrinter;

import java.util.List;

public class App {

    public static void main( String[] args ) {

        List<Employee> employees = new EmployeesDataFactory().buildEmployeesData();
        new HierarchyPrinter().printHierarchy(employees);

    }

}
