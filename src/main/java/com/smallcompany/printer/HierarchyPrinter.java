package com.smallcompany.printer;

import com.smallcompany.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HierarchyPrinter {

    private static final String SPACES = "       ";

    public void printHierarchy(List<Employee> allEmployees) {
        Objects.requireNonNull(allEmployees);

        Employee ceo = findCEO(allEmployees);
        findAndPrintEmployees(ceo, allEmployees, 1);
    }

    public Employee findCEO(List<Employee> allEmployees) {
        if(allEmployees.size() == 1){
            return allEmployees.get(0);
        }
        if(allEmployees.stream().filter(e -> e.getManagerId() == null).count() != 1){
            throw new IllegalStateException("Wrong number of CEOs");
        }
        return allEmployees.stream()
                .filter(e -> e.getManagerId() == null)
                .findFirst().get();
    }

    private void findAndPrintEmployees(Employee employee, List<Employee> allEmployees, Integer level) {
        printEmployee(employee, level);
        for(Employee empl: getEmployeesLevelBelow(employee, allEmployees)){
            findAndPrintEmployees(empl, allEmployees, level + 1);
        }
    }

    public List<Employee> getEmployeesLevelBelow(Employee manager, List<Employee> allEmployees){
        return allEmployees.stream()
                .filter(e -> e.getManagerId() != null)
                .filter(e -> e.getManagerId().equals(manager.getId()))
                .sorted(Comparator.comparing((Employee::getId)))
                .collect(Collectors.toList());
    }

    private void printEmployee(Employee employee, Integer level) {
        switch (level){
            case 1:
                //ceo
                System.out.println("| " + employee.getName() +  " |" + SPACES + "|" + SPACES + "| ");
                break;
            case 2:
                //manager
                System.out.println("|" + SPACES + "| " + employee.getName() +  " |" + SPACES + "| ");
                break;
            case 3:
                //the rest
                System.out.println("|" + SPACES + "|" + SPACES + "| " + employee.getName() +  " | ");
                break;
            default:
                System.out.print("There are only 3 accepted levels in the company!");
                break;
        }
    }
}
