package com.github.kevinnowak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

class ConstructorReferences {

    void main() {
        ArrayList<String> names = new ArrayList<>(List.of("Kevin", "Magdalena", "Iwona", "Amelia"));
        Stream<Person> stream1 = names.stream().map(Person::new);
        List<Person> people = stream1.toList();
        IO.println(people);

        Stream<Person> stream2 = names.stream().map(Person::new);
        Person[] people2 = stream2.toArray(Person[]::new);

        var dates = new Date[10];
        Arrays.setAll(dates, Date::new);
        IO.println(Arrays.toString(dates));
    }
}
