package com.github.kevinnowak.comparable_and_comparator;

// Comparable - natural ordering built into the class
class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Natural ordering by age
    @Override
    public int compareTo(Employee other) {
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", $" + salary + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
