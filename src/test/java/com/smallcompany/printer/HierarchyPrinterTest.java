package com.smallcompany.printer;

import com.smallcompany.datafactory.TestDataFactory;
import com.smallcompany.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class HierarchyPrinterTest {

    TestDataFactory dataFactory;
    HierarchyPrinter printer;

    @Before
    public void setUp() {
        dataFactory = new TestDataFactory();
        printer = new HierarchyPrinter();
    }

    @Test
    public void testFindCEO_happyPath() {
        List<Employee> employees = dataFactory.build6EmployeesData();
        Employee ceo = printer.findCEO(employees);

        assertThat(ceo.getName(), equalTo("Jamie"));
    }

    @Test
    public void testFindCEO_onlyCEO() {
        List<Employee> employees = dataFactory.buildEmployeesDataWithOnlyCEO();
        Employee ceo = printer.findCEO(employees);

        assertThat(ceo.getName(), equalTo("Jamie"));
    }

    @Test(expected = IllegalStateException.class)
    public void testFindCEO_2CEOs() {
        List<Employee> employees = dataFactory.buildEmployeesDataWith2CEOs();
        printer.findCEO(employees);
    }

    @Test
    public void testGetEmployeesLevelBelow_belowCEO(){
        List<Employee> allEmployees = dataFactory.build6EmployeesData();
        Employee ceo = printer.findCEO(allEmployees);

        List<Employee> employeesBelowCEO = printer.getEmployeesLevelBelow(ceo, allEmployees);

        assertThat(employeesBelowCEO.size(), equalTo(2));
        assertThat(employeesBelowCEO.get(0).getName(), equalTo("Alan"));
        assertThat(employeesBelowCEO.get(1).getName(), equalTo("Steve"));
    }

    @Test
    public void testGetEmployeesLevelBelow_belowManagerAlan(){
        List<Employee> allEmployees = dataFactory.build6EmployeesData();

        Employee alan = new Employee(100, "Alan", 150);
        List<Employee> employeesBelowCEO = printer.getEmployeesLevelBelow(alan, allEmployees);

        assertThat(employeesBelowCEO.size(), equalTo(2));
        assertThat(employeesBelowCEO.get(0).getName(), equalTo("Martin"));
        assertThat(employeesBelowCEO.get(1).getName(), equalTo("Alex"));
    }

}