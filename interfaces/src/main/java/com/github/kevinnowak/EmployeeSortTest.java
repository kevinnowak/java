package com.github.kevinnowak;

import java.util.Arrays;

class EmployeeSortTest {

    public static void main(String[] args) {
        var staff = new Employee[3];

        staff[0] = new Employee(("Harry Hacker"), 35_000);
        staff[1] = new Employee(("Carl Cracker"), 75_000);
        staff[2] = new Employee(("Tony Tester"), 38_000);

        Arrays.sort(staff);

        for (Employee e: staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }

        Comparable<Employee> x;

        x = new Employee("", 1);

        if (x instanceof Comparable<Employee>) {
            System.out.println("Yes");
        }
    }
}
