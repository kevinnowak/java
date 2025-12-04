package com.github.kevinnowak;

class Student implements Person, Named {

    @Override
    public String getName() {
        return Person.super.getName();
    }
}
