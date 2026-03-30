package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.enum_constants;

// Using class bodies to add behavior to an enum constant
enum OperationEnumWithClassBodies {

    PLUS {
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDED_BY {
        double eval(double x, double y) {
            return x / y;
        }
    };

    // Each constant supports an arithmetic operation
    abstract double eval(double x, double y);

    static void main() {
        double x = 2.0;
        double y = 4.0;

        for (var op : OperationEnumWithClassBodies.values()) {
            System.out.println(x + " " + op + " " + y + " = " + op.eval(x, y));
        }
    }
}
