package com.github.kevinnowak.java.java_api.function_types;

import java.time.LocalDate;
import java.util.function.Supplier;

class SupplierExample {

    // Interface: Supplier<T>
    // Signature: T get()

    static void main() {
        Supplier<LocalDate> supplier = LocalDate::now;
        IO.println(supplier.get());
    }
}
