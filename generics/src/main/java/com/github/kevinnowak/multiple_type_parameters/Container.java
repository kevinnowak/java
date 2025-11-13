package com.github.kevinnowak.multiple_type_parameters;

class Container<T, S> {

    private T item1;
    private S item2;

    Container(T item1, S item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    T getItem1() {
        return item1;
    }

    S getItem2() {
        return item2;
    }
}
