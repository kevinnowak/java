package com.github.kevinnowak;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

class FunctionTypes {

    void main() {
        BiFunction<String, String, Integer> comp = (first, second) -> first.length() - second.length();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        list.add(2);
        list.add(3);
        Predicate<Integer> predicate = e -> e == null;
        list.removeIf(predicate);
        IO.println(list);

        Supplier<Integer> supplier = () -> (int) (Math.random() * 6) + 1;
        IO.println("Supplier: " + supplier.get());

        LocalDate day = LocalDate.now();
        LocalDate hireDay1 = Objects.requireNonNullElse(day, LocalDate.of(1970, 1, 1));
        LocalDate hireDay2 = Objects.requireNonNullElseGet(day, () -> LocalDate.of(1970, 1, 1));

        var values = new int[100];
        Arrays.setAll(values, i -> i * i);
        IO.println(Arrays.toString(values));
    }
}
