package com.github.kevinnowak.upper_bounds;

class Main {

    public static void main(String[] args) {
        SchoolPerson person = new SchoolPerson("Peter");
        Bus<SchoolPerson> busWithPerson = new Bus<>(person);
        busWithPerson.printRider();
    }
}
