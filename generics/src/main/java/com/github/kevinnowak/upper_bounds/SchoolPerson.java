package com.github.kevinnowak.upper_bounds;

class SchoolPerson {

    private String name;

    SchoolPerson(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolPerson{" +
                "name='" + name + '\'' +
                '}';
    }
}
