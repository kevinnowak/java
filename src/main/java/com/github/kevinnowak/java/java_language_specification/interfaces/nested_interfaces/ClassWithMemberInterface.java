package com.github.kevinnowak.java.java_language_specification.interfaces.nested_interfaces;

class ClassWithMemberInterface {

    // Defining a member interface
    interface MemberInterface {
        static void doSomething() {
            System.out.println("Something");
        }
    }

    static void main() {
        ClassWithMemberInterface.MemberInterface.doSomething();
    }
}
