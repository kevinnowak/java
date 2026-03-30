package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.access_modifiers;

class OrderWithNestedOrderState {

    // Nested enum can be private, protected, public, or package-private
    private enum OrderState {
        PENDING,
        SHIPPED,
        DELIVERED
    }

}
