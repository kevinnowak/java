package com.github.kevinnowak.comparable_and_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 75_000),
                new Employee("Bob", 25, 60_000),
                new Employee("Charlie", 35, 90_000)
        );

        // Using Comparable (natural ordering by age)
        Collections.sort(employees);
        System.out.println("Sorted by age (Comparable): " + employees);

        // Comparator #1 - separate class for custom ordering by name
        class NameComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        }

        Collections.sort(employees, new NameComparator());
        System.out.println("Sorted by name (Comparator): " + employees);

        // Comparator #2 - lambda for another custom ordering by salary
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
//        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Sorted by salary (Comparator): " + employees);

        // Comparator #3 - using Comparator.comparing (cleaner)
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.println("Sorted by salary DESC: " + employees);
    }
}
