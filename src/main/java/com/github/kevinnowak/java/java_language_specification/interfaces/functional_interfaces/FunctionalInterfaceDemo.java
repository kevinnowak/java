package com.github.kevinnowak.java.java_language_specification.interfaces.functional_interfaces;

class FunctionalInterfaceDemo {

    static void main() {
        TextProcessor makeUppercase = text -> text.toUpperCase();
        IO.println("Uppercase: " + makeUppercase.process("hello java"));

        TextProcessor addExclamation = text -> text + "!";
        IO.println("Exclaim: " + addExclamation.process("Lambdas are cool"));

        TextProcessor trimWhitespace = String::trim;
        IO.println("Trimmed: |" + trimWhitespace.process("   spaces   ") + "|");

        makeUppercase.printTwice("Echo");
    }
}
