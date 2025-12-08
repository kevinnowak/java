package com.github.kevinnowak;

import java.util.*;

/**
 * Demonstrates the "Comparison method violates its general contract!" exception
 * that occurs when a Comparator violates the transitivity requirement.
 */
public class BrokenComparatorDemo {

    static class Person {
        String name;
        int age;
        double salary;

        Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s (age: %d, salary: $%.0f)", name, age, salary);
        }
    }

    /**
     * BROKEN COMPARATOR #1: Violates transitivity
     * This comparator tries to sort by multiple fields but does so incorrectly.
     * If age difference is small (< 5 years), it compares by salary.
     * Otherwise, it compares by age.
     *
     * This violates transitivity:
     * - If A.age=20, B.age=22, C.age=25
     * - A vs B: age diff < 5, compare by salary (say A > B)
     * - B vs C: age diff < 5, compare by salary (say B > C)
     * - A vs C: age diff >= 5, compare by age (A < C)
     * - But transitivity requires: if A > B and B > C, then A > C
     */
    static class BrokenComparator1 implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            int ageDiff = Math.abs(p1.age - p2.age);

            if (ageDiff < 5) {
                // Compare by salary if ages are close
                return Double.compare(p1.salary, p2.salary);
            } else {
                // Compare by age if ages are far apart
                return Integer.compare(p1.age, p2.age);
            }
        }
    }

    /**
     * BROKEN COMPARATOR #2: Violates consistency with equals
     * Returns 0 for some objects that aren't equal, but inconsistently
     */
    static class BrokenComparator2 implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            // This is broken: comparing age with salary threshold
            if (p1.age > 30 && p2.salary > 50000) {
                return 0; // Incorrectly says they're equal
            }
            return Integer.compare(p1.age, p2.age);
        }
    }

    /**
     * BROKEN COMPARATOR #3: Non-deterministic comparison
     * Uses random logic which violates consistency
     */
    static class BrokenComparator3 implements Comparator<Person> {
        private Random random = new Random();

        @Override
        public int compare(Person p1, Person p2) {
            int ageCompare = Integer.compare(p1.age, p2.age);

            // Randomly flip the result sometimes - this is broken!
            if (random.nextDouble() < 0.3) {
                return -ageCompare;
            }
            return ageCompare;
        }
    }

    public static void demonstrateBrokenComparator1() {
        System.out.println("=== BROKEN COMPARATOR #1: Violates Transitivity ===\n");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 20, 60000));
        people.add(new Person("Bob", 22, 55000));
        people.add(new Person("Charlie", 25, 50000));
        people.add(new Person("David", 21, 65000));
        people.add(new Person("Eve", 24, 52000));
        people.add(new Person("Frank", 23, 58000));
        people.add(new Person("Grace", 26, 54000));
        people.add(new Person("Henry", 19, 48000));

        System.out.println("Original list:");
        people.forEach(System.out::println);

        try {
            Collections.sort(people, new BrokenComparator1());
            System.out.println("\nSorted list:");
            people.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("\n*** EXCEPTION CAUGHT ***");
            System.out.println("Message: " + e.getMessage());
            System.out.println("\nThis happens because the comparator violates transitivity!");
            e.printStackTrace();
        }
    }

    public static void demonstrateBrokenComparator2() {
        System.out.println("\n\n=== BROKEN COMPARATOR #2: Inconsistent Logic ===\n");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 35, 60000));
        people.add(new Person("Bob", 32, 55000));
        people.add(new Person("Charlie", 28, 50000));
        people.add(new Person("David", 31, 65000));

        System.out.println("Original list:");
        people.forEach(System.out::println);

        try {
            Collections.sort(people, new BrokenComparator2());
            System.out.println("\nSorted list:");
            people.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("\n*** EXCEPTION CAUGHT ***");
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * CORRECT COMPARATOR for comparison
     */
    static class CorrectComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            // First compare by age
            int ageCompare = Integer.compare(p1.age, p2.age);
            if (ageCompare != 0) {
                return ageCompare;
            }
            // If ages are equal, then compare by salary
            return Double.compare(p1.salary, p2.salary);
        }
    }

    public static void demonstrateCorrectComparator() {
        System.out.println("\n\n=== CORRECT COMPARATOR: For Comparison ===\n");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 20, 60000));
        people.add(new Person("Bob", 22, 55000));
        people.add(new Person("Charlie", 25, 50000));
        people.add(new Person("David", 21, 65000));

        System.out.println("Original list:");
        people.forEach(System.out::println);

        Collections.sort(people, new CorrectComparator());
        System.out.println("\nSorted list (no exception!):");
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {
        demonstrateBrokenComparator1();
        demonstrateBrokenComparator2();
        demonstrateCorrectComparator();

        System.out.println("\n\n=== KEY RULES FOR VALID COMPARATORS ===");
        System.out.println("1. Transitivity: if compare(A,B) > 0 and compare(B,C) > 0, then compare(A,C) > 0");
        System.out.println("2. Symmetry: sgn(compare(A,B)) == -sgn(compare(B,A))");
        System.out.println("3. Consistency: compare(A,B) must always return the same result");
        System.out.println("4. If compare(A,B) == 0, then compare(A,C) and compare(B,C) must have same sign");
    }
}
