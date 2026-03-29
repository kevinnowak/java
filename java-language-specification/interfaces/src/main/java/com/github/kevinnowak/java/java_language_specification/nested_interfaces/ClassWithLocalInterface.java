package com.github.kevinnowak.java.java_language_specification.nested_interfaces;

class ClassWithLocalInterface {

    void validateAndProcess() {
        // Declare a local interface inside a method
        interface DataValidator {
            boolean isValid(String input);
        }

        // Implement the local interface
        DataValidator lengthValidator = (input) -> input != null && input.length() > 5;
        DataValidator contentValidator = (input) -> input != null && input.startsWith("ID_");

        String testString = "ID_123456";

        // Use the interface locally
        if (lengthValidator.isValid(testString) && contentValidator.isValid(testString)) {
            System.out.println("Data passed all local validations");
        } else {
            System.out.println("Data is invalid");
        }
    }

    static void main() {
        var classWithLocalInterface = new ClassWithLocalInterface();
        classWithLocalInterface.validateAndProcess();
    }
}
